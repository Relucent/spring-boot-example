package yyl.springboot.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * |~ http://localhost:8080/
 */
@RestController
public class HelloWebFluxController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello, WebFlux !";
	}

	@GetMapping("/mono")
	public Mono<String> mono() {
		return Mono.just("mono");
	}

	@GetMapping("/flux")
	public Flux<String> flux() {
		return Flux.just("hello", "webflux", "spring", "boot");
	}

	@GetMapping(path = "/stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<String> stream() {
		return Flux.range(1, 9).delayElements(Duration.ofSeconds(1)).map(String::valueOf);
	}
}