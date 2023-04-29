package com.svalero.libraryreactive.service;

import com.svalero.libraryreactive.domain.Library;
import com.svalero.libraryreactive.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public Flux<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public Mono<Library> findByCode(String code) {
        return libraryRepository.findByCode(code);
    }

    @Override
    public Mono<Library> addLibrary(Library library) {
        return libraryRepository.save(library);
    }
}
