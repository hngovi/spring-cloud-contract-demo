package com.example.hngovi.checkservice.spi;

import com.example.hngovi.checkservice.domain.model.GeoIp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
public class GeoIpIntegrationTest {

    private static final String EXPECTED = "{\"ip\":\"84.157.87.82\",\"country_code\":\"DE\",\"country_name\":\"Deutschland\",\"region_code\":\"HE\",\"region_name\":\"Hessen\",\"city\":\"Frankfurt am Main\",\"zip_code\":\"65929\",\"time_zone\":\"Europe/Berlin\",\"latitude\":50.1021,\"longitude\":8.5381,\"metro_code\":0}";

    WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToServer()
                .baseUrl("https://freegeoip.app")
                .build();
    }

    @Test
    void given_whenGetThenOk() throws Exception {
        webTestClient.get()
                .uri("/json/")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(GeoIp.class);
    }
}
