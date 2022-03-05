package com.baeldung.springreactive;

import com.baeldung.springreactive.client.FooClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringReactiveApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringReactiveApplication.class, args);

        FooClient fooClient = context.getBean(FooClient.class);
        fooClient.getFoo();
    }

}
