package com.svalero.libraryreactive.controller;

import com.svalero.libraryreactive.domain.Library;
import com.svalero.libraryreactive.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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
}
