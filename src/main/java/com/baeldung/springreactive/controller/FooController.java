package com.baeldung.springreactive.controller;

import com.baeldung.springreactive.model.Foo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@RestController
public class FooController {

    @GetMapping("/foo")
    public Flux<Foo> getFoo() {
        return findAll().delayElements(Duration.ofSeconds(1)).log();
    }

    private Flux<Foo> findAll() {
        Foo foo1 = Foo.builder().id(1).name("Abc").build();
        Foo foo2 = Foo.builder().id(2).name("Xyz").build();
        Foo foo3 = Foo.builder().id(3).name("Mno").build();

        return Flux.fromIterable(List.of(foo1, foo2, foo3));
    }
}
