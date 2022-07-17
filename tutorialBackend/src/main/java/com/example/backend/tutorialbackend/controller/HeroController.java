package com.example.backend.tutorialbackend.controller;

import com.example.backend.tutorialbackend.model.Hero;
import com.example.backend.tutorialbackend.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
}
