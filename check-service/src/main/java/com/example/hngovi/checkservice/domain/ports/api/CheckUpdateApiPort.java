package com.example.hngovi.checkservice.domain.ports.api;

import com.example.hngovi.checkservice.domain.model.Customer;
import com.example.hngovi.checkservice.domain.model.UpdateRelease;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface CheckUpdateApiPort {
    public List<UpdateRelease> askForUpdate(Customer customer);
}
