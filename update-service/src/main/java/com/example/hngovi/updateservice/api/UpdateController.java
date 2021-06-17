package com.example.hngovi.updateservice.api;

import com.example.hngovi.updateservice.domain.model.UpdateRelease;
import com.example.hngovi.updateservice.domain.ports.api.UpdateReleaseApiPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UpdateController {

    private UpdateReleaseApiPort updateService;

    @Autowired
    public UpdateController(UpdateReleaseApiPort updateService) {
        this.updateService = updateService;
    }

    @GetMapping("/updates")
    public List<UpdateRelease> getUpdates() {
        return updateService.getUpdates();
    }
}
