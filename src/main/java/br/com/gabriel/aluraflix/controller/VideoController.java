package br.com.gabriel.aluraflix.controller;

import br.com.gabriel.aluraflix.video.DadosVideo;
import br.com.gabriel.aluraflix.video.Video;
import br.com.gabriel.aluraflix.video.VideoRepository;
import br.com.gabriel.aluraflix.video.VideoService;
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
@RequestMapping("videos")
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
    public void cadastrar(@RequestBody @Valid DadosVideo dados){
        repository.save(new Video(dados));
    }
}
