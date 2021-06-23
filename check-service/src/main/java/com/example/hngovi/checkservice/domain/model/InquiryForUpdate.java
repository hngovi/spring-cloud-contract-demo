package com.example.hngovi.checkservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InquiryForUpdate {
    private Customer customer;
    private GeoIp geoIp;
    private List<UpdateRelease> updateReleaseList;
    private LocalDate localDate;

}
