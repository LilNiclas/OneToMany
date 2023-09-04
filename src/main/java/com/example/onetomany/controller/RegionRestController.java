package com.example.onetomany.controller;

import com.example.onetomany.model.Region;
import com.example.onetomany.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegionRestController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;



    @GetMapping ("/regioner")
    public List<Region> getRegioner() {
        List<Region> regionListe = apiServiceGetRegioner.getRegioner();
        return regionListe;
    }
   /*
    @PostMapping ("/region")
    @ResponseStatus(HttpStatus.CREATED)
    public Region postRegion(@RequestBody Region region) {
        System.out.println(region);
        return
    }
*/
}