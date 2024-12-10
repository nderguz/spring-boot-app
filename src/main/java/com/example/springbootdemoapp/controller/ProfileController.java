package com.example.springbootdemoapp.controller;

import com.example.springbootdemoapp.service.SystemProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProfileController {
    private final SystemProfile systemProfile;

    public ProfileController(SystemProfile systemProfile) {
        this.systemProfile = systemProfile;
    }

    @GetMapping
    public String getProfile() {
        return systemProfile.getProfile();
    }
}
