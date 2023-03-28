package br.com.gabriel.aluraflix.video;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoVideo(

        @NotNull
        Long id,

        String titulo,

        String descricao,

        String url
) {

}
