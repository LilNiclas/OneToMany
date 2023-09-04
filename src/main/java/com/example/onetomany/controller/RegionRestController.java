package com.example.onetomany.controller;

import com.example.onetomany.model.Region;
import com.example.onetomany.repository.RegionRepository;
import com.example.onetomany.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RegionRestController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @Autowired
    RegionRepository regionRepository;


    //Get all regions through API
    @GetMapping ("/regionerAPI")
    public List<Region> getRegionerAPI() {
        List<Region> regionListe = apiServiceGetRegioner.getRegioner();
        return regionListe;
    }

    //Get all regions through database
    @GetMapping ("/regioner")
    public List<Region> getRegioner() {
        List<Region> regionListe = regionRepository.findAll();
        return regionListe;
    }

    //Add region
    @PostMapping ("/region")
    @ResponseStatus(HttpStatus.CREATED)
    public Region postRegion(@RequestBody Region region) {
        System.out.println(region);
        return regionRepository.save(region);
    }

    //Update Region
    @PutMapping ("/region/{id}")
    public ResponseEntity<Region> putRegion(@PathVariable String id, @RequestBody Region region) {
        Optional<Region> orgRegion = regionRepository.findById(id);
        if(orgRegion.isPresent()) {
            regionRepository.save(region);
            return new ResponseEntity<>(region, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Region(), HttpStatus.NOT_FOUND);
        }
    }

    //Delete Region
    @DeleteMapping ("/region/{id}")
    public ResponseEntity<String> deleteRegion(@PathVariable String id) {
        Optional<Region> orgRegion = regionRepository.findById(id);
        if(orgRegion.isPresent()) {
            regionRepository.deleteById(id);
            return  ResponseEntity.ok("Region deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Region not found");
        }
    }
}