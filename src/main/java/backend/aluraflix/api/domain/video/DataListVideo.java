package backend.aluraflix.api.domain.video;

public record DataListVideo(Long id, String titulo, String descricao, String url) {

    public DataListVideo(Video video) {
        this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
    }

}
