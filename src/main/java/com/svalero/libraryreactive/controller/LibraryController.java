package com.svalero.libraryreactive.controller;

import com.svalero.libraryreactive.domain.Library;
import com.svalero.libraryreactive.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping(value = "/libraries", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Library> getLibraries() {
        return libraryService.findAll().delayElements(Duration.ofSeconds(3));
    }

    @PostMapping(value = "/libraries")
    public void addLibrary(@RequestBody Library library) {
        libraryService.addLibrary(library).block();
    }

    @GetMapping(value = "/library/{id}")
    public Mono<Library> getById (@PathVariable String id) {
        return libraryService.findById(id);
    }
    @GetMapping(value = "/libraries/{city}")
    public Flux<Library> getByCity (@PathVariable String city) {
        return libraryService.findByCity(city);
    }

    @PutMapping(value = "library/{id}")
    public void updateLibrary(@PathVariable String id, @RequestBody Library newLibrary) {
        libraryService.updateLibrary(id, newLibrary).block();
    }

    @DeleteMapping(value = "/library/{id}")
    public Mono<Void> deleteLibrary (@PathVariable String id) {
        return libraryService.deleteLibrary(id);
    }

}
