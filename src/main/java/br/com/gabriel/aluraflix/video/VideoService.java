package br.com.gabriel.aluraflix.video;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository repository;

    public Video findById(Long id){
        Optional<Video> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Video.class.getName()));
    }
}
