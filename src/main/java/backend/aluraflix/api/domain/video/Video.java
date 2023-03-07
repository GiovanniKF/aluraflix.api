package backend.aluraflix.api.domain.video;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "videos")
@Entity(name = "Video")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Video {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String url;

    public Video(DataRegisterVideo datas) {
        this.titulo = datas.titulo();
        this.descricao = datas.descricao();
        this.url = datas.url();
    }

    public void updateVideoInformation(DataUpdateVideo data) {
        this.titulo = data.titulo();
        this.descricao = data.descricao();
        this.url = data.url();
    }
}
