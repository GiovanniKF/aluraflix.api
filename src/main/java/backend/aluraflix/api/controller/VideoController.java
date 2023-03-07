package backend.aluraflix.api.controller;

import backend.aluraflix.api.domain.video.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoRepository repository;

    @GetMapping
    public List<DataListVideo> list() {
        return repository.findAll().stream().map(DataListVideo::new).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var video = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailVideo(video));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DataRegisterVideo datas, UriComponentsBuilder uriBuilder) {
        var video = new Video(datas);
        repository.save(video);

        var uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailVideo(video));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataUpdateVideo data) {
        var video = repository.getReferenceById(data.id());
        video.updateVideoInformation(data);

        return ResponseEntity.ok(new DataDetailVideo(video));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var video = repository.getReferenceById(id);
        repository.delete(video);
        return ResponseEntity.noContent().build();
    }
}
