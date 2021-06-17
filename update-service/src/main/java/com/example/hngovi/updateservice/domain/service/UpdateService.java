package com.example.hngovi.updateservice.domain.service;

import com.example.hngovi.updateservice.domain.model.UpdateRelease;
import com.example.hngovi.updateservice.domain.ports.api.UpdateReleaseApiPort;
import com.example.hngovi.updateservice.domain.ports.spi.UpdateReleaseSpiPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateService implements UpdateReleaseApiPort {

    @Autowired
    private UpdateReleaseSpiPort updateReleaseSpiPort;

    public List<UpdateRelease> getUpdates() {
        return updateReleaseSpiPort.getUpdates();
    }
}
