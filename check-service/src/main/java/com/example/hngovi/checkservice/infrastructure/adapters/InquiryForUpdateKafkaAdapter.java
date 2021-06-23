package com.example.hngovi.checkservice.infrastructure.adapters;

import com.example.hngovi.checkservice.domain.model.Customer;
import com.example.hngovi.checkservice.domain.model.GeoIp;
import com.example.hngovi.checkservice.domain.model.InquiryForUpdate;
import com.example.hngovi.checkservice.domain.model.UpdateRelease;
import com.example.hngovi.checkservice.domain.ports.api.InquiryForUpdatePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InquiryForUpdateKafkaAdapter implements InquiryForUpdatePort {

    @Autowired
    private KafkaTemplate<String, InquiryForUpdate> kafkaTemplate;

    @Value("${kafka.update.topic}")
    private String kafkaTopicName;

    @Override
    public void newInquiryForUpdate(Customer customer, GeoIp geoIp, List<UpdateRelease> updateReleases, LocalDate localDate) {
        InquiryForUpdate inquiryForUpdate = new InquiryForUpdate(customer, geoIp, updateReleases, localDate);
        kafkaTemplate.send(kafkaTopicName, customer.getName() + "-" + customer.getEmail(), inquiryForUpdate);
    }
}
