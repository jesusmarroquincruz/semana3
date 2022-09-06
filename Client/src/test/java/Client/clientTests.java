package Client;

import Client.controller.ClientController;
import Client.model.Client;
import Client.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@SpringBootTest
class clientTests {
	@Autowired
	ClientController miservicio;

	@Test
	void contextLoads() {
		Flux<Client> uno2 = miservicio.list().getBody();
		StepVerifier.create(uno2).expectNext().verifyComplete();

	}

	@Test
	void testMono() {

		Mono<String> uno = miservicio.buscarUno();
		StepVerifier.create(uno).expectNext("hola").verifyComplete();
	}

}
