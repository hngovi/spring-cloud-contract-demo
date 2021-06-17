package com.example.hngovi.updateservice.infrastructure.adapters;

import com.example.hngovi.updateservice.domain.model.UpdateRelease;
import com.example.hngovi.updateservice.domain.ports.spi.UpdateReleaseSpiPort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateReleaseStaticAdapter implements UpdateReleaseSpiPort {

    private static List<UpdateRelease> updateReleaseList;
    static {
        updateReleaseList = new ArrayList<>();
        updateReleaseList.add(new UpdateRelease(1L, "IMPORTANT"));
    }

    @Override
    public List<UpdateRelease> getUpdates() {
        return updateReleaseList;
    }
}
