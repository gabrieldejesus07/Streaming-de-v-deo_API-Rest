package br.com.gabriel.aluraflix.controller;

import br.com.gabriel.aluraflix.video.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    public VideoRepository repository;

    @GetMapping
    public List<Video> listar(){
        return repository.findAll();
    }

    @Autowired
    private VideoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Video> findById(@PathVariable Long id){
        Video obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Transactional
    public Video cadastrar(@RequestBody @Valid DadosVideo dados){
        return repository.save(new Video(dados));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoVideo dados){
        var video = repository.getReferenceById(dados.id());
        video.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhadosVideo(video));
    }
}
