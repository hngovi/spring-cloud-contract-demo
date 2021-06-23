package com.example.hngovi.checkservice.domain.ports.api;

import com.example.hngovi.checkservice.domain.model.Customer;
import com.example.hngovi.checkservice.domain.model.GeoIp;
import com.example.hngovi.checkservice.domain.model.UpdateRelease;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface InquiryForUpdatePort {
    public void newInquiryForUpdate(Customer customer, GeoIp geoIp, List<UpdateRelease> updateReleases, LocalDate localDate);
}
