package com.example.hngovi.checkservice.spi;

import com.example.hngovi.checkservice.domain.ports.api.CheckUpdateApiPort;
import com.example.hngovi.checkservice.domain.service.CheckUpdateService;
import com.example.hngovi.checkservice.infrastructure.adapters.UpdateServiceInternetAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.example.hngovi:update-service:+:stubs:8090"
)
@SpringBootTest
@AutoConfigureWebTestClient
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
