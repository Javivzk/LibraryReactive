package com.svalero.libraryreactive.service;

import com.svalero.libraryreactive.domain.Library;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LibraryService {

    Flux<Library> findAll();
    Mono<Library> findByCode(String code);
    Mono<Library> addLibrary(Library library);
}
