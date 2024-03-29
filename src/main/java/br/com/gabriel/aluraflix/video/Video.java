package br.com.gabriel.aluraflix.video;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "videos")
@Entity(name = "Video")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String titulo;
    private String descricao;
    private String url;

    private boolean ativo;
    public Video(DadosVideo dados){
        this.ativo = true;
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.url = dados.url();
    }

    public void atualizarInformacoes(DadosAtualizacaoVideo dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();

            if (dados.url() != null) {
                this.url = dados.url();
            }

        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
