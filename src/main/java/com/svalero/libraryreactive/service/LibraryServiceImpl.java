package com.svalero.libraryreactive.service;

import com.svalero.libraryreactive.domain.Library;
import com.svalero.libraryreactive.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service

public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public Flux<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public Mono<Library> findById(String id) {
        return libraryRepository.findById(id);
    }

    @Override
    public Mono<Library> addLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Flux<Library> findByCity(String ciudad) {
        return libraryRepository.findByCity(ciudad);
    }

    @Override
    public Mono<Library> updateLibrary(String id, Library newLibrary) {
        return libraryRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalLibrary ->{
                    if (optionalLibrary.isPresent()) {
                        newLibrary.setId(id);
                        return libraryRepository.save(newLibrary);
                    }
                    return Mono.empty();
                });
    }

    @Override
    public Mono<Void> deleteLibrary(String id) {
        return libraryRepository.deleteById(id);
    }
}
