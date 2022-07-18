package com.example.backend.tutorialbackend.service;

import com.example.backend.tutorialbackend.model.Hero;
import com.example.backend.tutorialbackend.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Locale;

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

    public Mono<Hero> buscarPorId(String id){
        return heroRepository.findById(id);
    }

    public Mono<Hero> actualizar(Hero hero) {
        return heroRepository.save(hero);
    }

    public Mono<Void> borrar(String id) {
        System.out.println("Item with id " + id + " deleted...");
        return heroRepository.deleteById(id);

    }

    public Mono<List<Hero>> buscarPorNombre(String name){
        String busqueda = name.toLowerCase(Locale.ROOT);
        Flux<Hero> todos=heroRepository.findAll();
        return todos.filter(filtro->filtro.getName().toLowerCase().contains(busqueda)).collectList();
    }

}
