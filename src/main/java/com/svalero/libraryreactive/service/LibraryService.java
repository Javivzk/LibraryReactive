package com.svalero.libraryreactive.service;

import com.svalero.libraryreactive.domain.Library;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LibraryService {

    Flux<Library> findAll();
    Mono<Library> findById(String id);
    Mono<Library> addLibrary(Library library);
    Flux<Library> findByCity(String city);
    Mono<Library> updateLibrary(String id, Library newLibrary);

    Mono<Void> deleteLibrary(String id);



}
