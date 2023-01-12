package br.com.gabriel.aluraflix.video;

import jakarta.validation.constraints.NotBlank;

public record DadosVideo(

        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        String url
) {

}
