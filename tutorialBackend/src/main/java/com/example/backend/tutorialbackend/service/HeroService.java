package com.example.backend.tutorialbackend.service;

import com.example.backend.tutorialbackend.model.Hero;
import com.example.backend.tutorialbackend.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroService {
    @Autowired
    HeroRepository heroRepository;

    public Mono<Hero> crear(Hero hero) {
        return heroRepository.save(hero);
    }

    public Flux<Hero> buscarTodos() {
        return heroRepository.findAll();
    }
}
