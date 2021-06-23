package com.example.hngovi.checkservice.api;

import com.example.hngovi.checkservice.domain.model.Customer;
import com.example.hngovi.checkservice.domain.model.UpdateRelease;
import com.example.hngovi.checkservice.domain.ports.api.CheckUpdateApiPort;
import com.example.hngovi.checkservice.domain.service.CheckUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CheckUpdateController {

    @Autowired
    CheckUpdateApiPort checkUpdateService;

    @PostMapping("/askForUpdate")
    public Flux<UpdateRelease> askForUpdate(@RequestBody Customer customer) {
        return Flux.fromIterable(checkUpdateService.askForUpdate(customer));
    }
}
