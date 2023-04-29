package com.svalero.libraryreactive.repository;

import com.svalero.libraryreactive.domain.Library;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface LibraryRepository extends ReactiveMongoRepository<Library, String> {

    Flux<Library> findAll();
    Mono<Library> findById(String id);

    Flux<Library> findByCity(String city);

}
