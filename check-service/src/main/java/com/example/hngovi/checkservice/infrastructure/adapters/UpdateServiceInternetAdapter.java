package com.example.hngovi.checkservice.infrastructure.adapters;

import com.example.hngovi.checkservice.domain.model.UpdateRelease;
import com.example.hngovi.checkservice.domain.ports.spi.UpdateServiceSpiPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class UpdateServiceInternetAdapter implements UpdateServiceSpiPort {
    @Value("${updateservice.uri}")
    private String updateServiceUri;

    @Override
    public List<UpdateRelease> getAvailableUpdates() {
        Flux<UpdateRelease> flux = WebClient.create()
                .get()
                .uri(updateServiceUri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(UpdateRelease.class);

        return flux
                .onErrorReturn(null)
                .collectList().block();
    }
}
