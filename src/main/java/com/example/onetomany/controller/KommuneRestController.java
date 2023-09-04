package com.example.onetomany.controller;


import com.example.onetomany.model.Kommune;
import com.example.onetomany.repository.KommuneRepository;
import com.example.onetomany.service.ApiServiceGetKommuner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KommuneRestController {

    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("/kommuner")
    public List<Kommune> getKommuner() {
        List<Kommune> kommuneList = apiServiceGetKommuner.getKommuner();
        return kommuneList;
    }
}
