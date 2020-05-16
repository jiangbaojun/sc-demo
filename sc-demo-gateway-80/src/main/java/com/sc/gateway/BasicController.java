package com.sc.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BasicController {
    @GetMapping("/t2")
    public Mono<String> sayHelloWorld() {
        return Mono.just("Hello t2");
    }
}