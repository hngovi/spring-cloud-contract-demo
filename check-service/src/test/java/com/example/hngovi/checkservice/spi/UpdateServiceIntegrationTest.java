package com.example.hngovi.checkservice.spi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.example.hngovi:update-service:+:stubs:8090"
)
@WebFluxTest
public class UpdateServiceIntegrationTest {

    private static final String EXPECTED = "[{\"id\":1,\"description\":\"IMPORTANT\"}]";

    WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8090")
                .build();
    }

    @Test
    void given_whenGetUpdates_ThenReturnList() throws Exception {
        webTestClient.get()
                .uri("/updates")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody().json(EXPECTED);
    }
}
