package com.example.backend.tutorialbackend.controller;

import com.example.backend.tutorialbackend.model.Hero;
import com.example.backend.tutorialbackend.repository.HeroRepository;
import com.example.backend.tutorialbackend.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {
    @Autowired
    HeroService heroService;

    @PostMapping("/crear")
    public ResponseEntity<Mono<Hero>> guardar(@RequestBody Hero hero) {
        return new ResponseEntity(heroService.crear(hero), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Hero>> traerTodos() {
        return new ResponseEntity(heroService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mono<Hero>> buscarPorId(@PathVariable("id") String id){
        return new ResponseEntity(heroService.buscarPorId(id),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {

        return new ResponseEntity(heroService.borrar(id), HttpStatus.OK);

    }

        @PutMapping("/crear")
    public ResponseEntity<Mono<Hero>> actualizar(@RequestBody Hero hero) {
        if(hero.getId() != null) {
            return new ResponseEntity(heroService.actualizar(hero), HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/buscarNombre/{name}")
    public Mono<List<Hero>> buscarPorNombre(@PathVariable("name") String name){
        return heroService.buscarPorNombre(name);
    }

}