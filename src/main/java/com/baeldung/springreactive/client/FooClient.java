package com.baeldung.springreactive.client;

import com.baeldung.springreactive.model.Foo;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class FooClient {

    private final WebClient client;

    public FooClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8080").build();
    }

    public void getFoo() {
        Flux<Foo> foo = this.client.get().uri("/foo")
                .retrieve()
                .bodyToFlux(Foo.class);

        foo.subscribe(System.out::println);
    }
}
