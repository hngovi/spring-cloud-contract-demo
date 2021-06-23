package com.example.hngovi.checkservice.domain.ports.spi;

import com.example.hngovi.checkservice.domain.model.UpdateRelease;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UpdateServiceSpiPort {
    public List<UpdateRelease> getAvailableUpdates();
}
