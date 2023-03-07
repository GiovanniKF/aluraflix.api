package backend.aluraflix.api.domain.video;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataRegisterVideo(
        @NotBlank
        String titulo,

        @NotBlank
        String descricao,

        @NotBlank
        @Pattern(regexp = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")
        String url) {
}
