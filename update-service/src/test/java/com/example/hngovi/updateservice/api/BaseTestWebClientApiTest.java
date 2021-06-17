package com.example.hngovi.updateservice.api;

import com.example.hngovi.updateservice.domain.model.UpdateRelease;
import com.example.hngovi.updateservice.domain.ports.api.UpdateReleaseApiPort;
import com.example.hngovi.updateservice.domain.ports.spi.UpdateReleaseSpiPort;
import com.example.hngovi.updateservice.domain.service.UpdateService;
import io.restassured.module.webtestclient.RestAssuredWebTestClient;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.mockito.Mockito.when;

@WebFluxTest
public abstract class BaseTestWebClientApiTest {

    // Mocked SPI port
    @MockBean
    UpdateReleaseApiPort spiPort;

    // Mocked controller
    @MockBean
    UpdateController updateController;

    @BeforeEach
    void setUp() {
        when(spiPort.getUpdates()).thenReturn(List.of(new UpdateRelease(1L, "IMPORTANT")));
        RestAssuredWebTestClient.standaloneSetup(new UpdateController(spiPort));
    }
}
