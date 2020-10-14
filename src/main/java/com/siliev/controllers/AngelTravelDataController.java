package com.siliev.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/travel/angel")
public class AngelTravelDataController {

    @GetMapping("/data")
    public ResponseEntity getInformationAboutTraveling(
        @RequestParam String startCountry,
        @RequestParam Double budgetPerCountry,
        @RequestParam Double totalBudget
    ) {
        return ResponseEntity.ok().build();
    }

}
