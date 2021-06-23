package com.example.hngovi.checkservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeoIp {
    private static final String EXPECTED = "{\"ip\":\"84.157.87.82\",\"country_code\":\"DE\",\"country_name\":\"Deutschland\",\"region_code\":\"HE\",\"region_name\":\"Hessen\",\"city\":\"Frankfurt am Main\",\"zip_code\":\"65929\",\"time_zone\":\"Europe/Berlin\",\"latitude\":50.1021,\"longitude\":8.5381,\"metro_code\":0}";
    private String ip;
    private String country_code;
    private String country_name;
    private String region_code;
    private String region_name;
    private String city;
    private String zip_code;
    private String time_zone;
    private long latitude;
    private long longitude;
    private int metro_code;
}
