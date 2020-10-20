package com.siliev.controllers;

import com.siliev.dto.InformationAboutTheTrip;
import com.siliev.dto.TravelData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/travel/angel")
public interface RatesCollectorController {

    @PostMapping("/information")
    ResponseEntity<InformationAboutTheTrip> getInformationAboutTraveling(@RequestBody TravelData travelData);

    @GetMapping("/restricted")
    public String restricted();
}
