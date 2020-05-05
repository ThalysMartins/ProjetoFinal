package thalysmartins.filmesbancoh2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import thalysmartins.filmesbancoh2.model.MovieEntity;
import thalysmartins.filmesbancoh2.repository.MovieRepository;

import java.util.List;

/**
 * @Author Thalys Figueira Martins
 * @Since 24/04/2020
 * @version 1.0
 */

@RestController
@RequestMapping("/filmes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieEntity movieEntity;

    @GetMapping
    public ResponseEntity<List<MovieEntity>> findAll() {
        return new ResponseEntity<List<MovieEntity>>(
                (List<MovieEntity>) this.movieRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MovieEntity> findById(@PathVariable("id") long id) {
        if(this.movieRepository.findById(id).isPresent()) {
            return new ResponseEntity<MovieEntity>(
                    this.movieRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<MovieEntity>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MovieEntity> store(@RequestBody MovieEntity movieEntity) {
        return new ResponseEntity<MovieEntity>(
                this.movieRepository.save(movieEntity),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MovieEntity> update(@PathVariable("id") long id,
                                              @RequestBody MovieEntity movieEntity) throws Exception {
        if(id == 0 || !this.movieRepository.existsById(id)) {
            throw new Exception("Filme nao encontrado!");
        }
        return new ResponseEntity<MovieEntity>(
                this.movieRepository.save(movieEntity),
                new HttpHeaders(),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MovieEntity> delete(@PathVariable("id") long id) {
        this.movieRepository.deleteById(id);
        return new ResponseEntity<MovieEntity>(new HttpHeaders(), HttpStatus.OK);
    }
}
