package com.example.hngovi.checkservice.domain.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class InquiryForUpdateTest {
    private Customer customer;
    private GeoIp geoIp;
    private List<UpdateRelease> updateReleaseList;
    private LocalDate localDate;

    @Test
    void jsonOutput() {
        customer = new Customer("name", "name@email.mail");
        geoIp = new GeoIp();
        updateReleaseList = new ArrayList<>();
        updateReleaseList.add(new UpdateRelease(1L, "IMPORTANT"));
        localDate = LocalDate.now();

        InquiryForUpdate inquiryForUpdate = new InquiryForUpdate(customer, geoIp, updateReleaseList, localDate);


    }
}