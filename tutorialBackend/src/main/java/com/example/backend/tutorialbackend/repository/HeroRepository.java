package com.example.backend.tutorialbackend.repository;

import com.example.backend.tutorialbackend.model.Hero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface HeroRepository extends ReactiveMongoRepository<Hero, String> {
}
