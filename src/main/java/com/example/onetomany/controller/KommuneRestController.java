package com.example.onetomany.controller;


import com.example.onetomany.model.Kommune;
import com.example.onetomany.model.Region;
import com.example.onetomany.repository.KommuneRepository;
import com.example.onetomany.service.ApiServiceGetKommuner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KommuneRestController {

    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    @Autowired
    KommuneRepository kommuneRepository;

    //Get all kommuner through API
    @GetMapping("/kommunerAPI")
    public List<Kommune> getKommunerAPI() {
        List<Kommune> kommuneList = apiServiceGetKommuner.getKommuner();
        return kommuneList;
    }

    //Get all kommuner through database
    @GetMapping ("/kommuner")
    public List<Kommune> getKommuner() {
        List<Kommune> kommuneList = kommuneRepository.findAll();
        return kommuneList;
    }


    //Add region
    @PostMapping("/kommune")
    @ResponseStatus(HttpStatus.CREATED)
    public Kommune postKommune(@RequestBody Kommune kommune) {
        System.out.println(kommune);
        return kommuneRepository.save(kommune);
    }

    //Update Region
    @PutMapping ("/kommune/{id}")
    public ResponseEntity<Kommune> putKommune(@PathVariable String id, @RequestBody Kommune kommune) {
        Optional<Kommune> orgKommune = kommuneRepository.findById(id);
        if(orgKommune.isPresent()) {
            kommuneRepository.save(kommune);
            return new ResponseEntity<>(kommune, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Kommune(), HttpStatus.NOT_FOUND);
        }
    }

    //Delete Region
    @DeleteMapping ("/kommune/{id}")
    public ResponseEntity<String> deleteKommune(@PathVariable String id) {
        Optional<Kommune> orgKommune = kommuneRepository.findById(id);
        if(orgKommune.isPresent()) {
            kommuneRepository.deleteById(id);
            return  ResponseEntity.ok("Kommune deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kommune not found");
        }
    }


}
