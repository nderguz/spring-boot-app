package com.example.springbootdemoapp.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "netology.profile.dev", havingValue = "false")
public class ProductionProfile implements SystemProfile {

    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
