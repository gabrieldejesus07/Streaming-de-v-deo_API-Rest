package br.com.gabriel.aluraflix.controller;

import br.com.gabriel.aluraflix.video.DadosVideo;
import br.com.gabriel.aluraflix.video.Video;
import br.com.gabriel.aluraflix.video.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
