package com.example.hngovi.checkservice.domain.service;

import com.example.hngovi.checkservice.domain.model.Customer;
import com.example.hngovi.checkservice.domain.model.GeoIp;
import com.example.hngovi.checkservice.domain.model.UpdateRelease;
import com.example.hngovi.checkservice.domain.ports.api.CheckUpdateApiPort;
import com.example.hngovi.checkservice.domain.ports.api.InquiryForUpdatePort;
import com.example.hngovi.checkservice.domain.ports.spi.GeoIpSpiPort;
import com.example.hngovi.checkservice.domain.ports.spi.UpdateServiceSpiPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class CheckUpdateService implements CheckUpdateApiPort {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Autowired
    private UpdateServiceSpiPort updateServiceSpi;

    @Autowired
    GeoIpSpiPort geoIpSpi;

    @Autowired
    InquiryForUpdatePort inquiryForUpdateApi;

    @Override
    public List<UpdateRelease> askForUpdate(Customer customer) {

        Future<List<UpdateRelease>> listUpdateReleaseFuture = executorService.submit(() -> {
            return updateServiceSpi.getAvailableUpdates();
        });

        Future<GeoIp> geoIpFuture = executorService.submit(() -> {
            return geoIpSpi.get();
        });

        boolean success = (listUpdateReleaseFuture.isDone() && !listUpdateReleaseFuture.isCancelled())
                && (geoIpFuture.isDone() && !geoIpFuture.isCancelled());

        if(success) {
            try {
                inquiryForUpdateApi.newInquiryForUpdate(customer, geoIpFuture.get(), listUpdateReleaseFuture.get(), LocalDate.now());
            } catch (ExecutionException e) {
                e.printStackTrace();
                return null;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }

        }

        return null;
    }
}
