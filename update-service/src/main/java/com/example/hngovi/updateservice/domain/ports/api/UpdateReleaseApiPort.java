package com.example.hngovi.updateservice.domain.ports.api;

import com.example.hngovi.updateservice.domain.model.UpdateRelease;

import java.util.List;

public interface UpdateReleaseApiPort {
    public List<UpdateRelease> getUpdates();
}
