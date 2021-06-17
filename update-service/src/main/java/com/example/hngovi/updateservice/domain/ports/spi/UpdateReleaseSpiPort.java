package com.example.hngovi.updateservice.domain.ports.spi;

import com.example.hngovi.updateservice.domain.model.UpdateRelease;

import java.util.List;

public interface UpdateReleaseSpiPort {
    public List<UpdateRelease> getUpdates();
}
