package com.example.hngovi.checkservice.infrastructure.adapters;

import com.example.hngovi.checkservice.domain.model.GeoIp;
import com.example.hngovi.checkservice.domain.ports.spi.GeoIpSpiPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GeoIpInternetAdapter implements GeoIpSpiPort {
    @Value("${geoip.uri}")
    private String geoIpUri;

    @Override
    public GeoIp get() {

        Mono<GeoIp> mono = WebClient.create()
                .get()
                .uri(geoIpUri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GeoIp.class);

        return mono
                .onErrorReturn(null)
                .block();
    }
}
