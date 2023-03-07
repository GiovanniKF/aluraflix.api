package backend.aluraflix.api.domain.video;

public record DataDetailVideo(Long id, String titulo, String descricao, String url) {

    public DataDetailVideo(Video video) {
        this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
    }
}
