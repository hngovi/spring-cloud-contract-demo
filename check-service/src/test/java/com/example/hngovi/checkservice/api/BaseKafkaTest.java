package com.example.hngovi.checkservice.api;

import com.example.hngovi.checkservice.domain.model.Customer;
import com.example.hngovi.checkservice.domain.model.GeoIp;
import com.example.hngovi.checkservice.domain.model.UpdateRelease;
import com.example.hngovi.checkservice.domain.ports.api.InquiryForUpdatePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMessageVerifier
@EmbeddedKafka(partitions = 1, topics = {"inquiry-input"})
@ActiveProfiles("test")
public abstract class BaseKafkaTest {

    @Autowired
    InquiryForUpdatePort inquiryForUpdate;

    public void triggerMessage() {
        Customer customer = new Customer("name", "name@email.com");
        GeoIp geoIp = new GeoIp("", "", "",
                "", "", "", "", "",
                0L, 0L, 0);
        List<UpdateRelease> updateReleaseList = new ArrayList<>();
        updateReleaseList.add(new UpdateRelease(1L, "IMPORTANT"));
        LocalDate localDate = LocalDate.of(2021, 6, 28);

        inquiryForUpdate.newInquiryForUpdate(customer, geoIp, updateReleaseList, localDate);
    }
}
