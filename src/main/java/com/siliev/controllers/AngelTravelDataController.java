package com.siliev.controllers;

import com.siliev.dto.CountryBordersDto;
import com.siliev.services.CountryBordersService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/travel/angel")
public class AngelTravelDataController {

    private final CountryBordersService countryBordersService;

    public AngelTravelDataController(CountryBordersService countryBordersService) {
        this.countryBordersService = countryBordersService;
    }

    @GetMapping("/data")
    public ResponseEntity<List<CountryBordersDto>> getInformationAboutTraveling(
        @RequestParam(value = "startCountry") String startCountry,
        @RequestParam(value = "budgetPerCountry", required = false) Double budgetPerCountry,
        @RequestParam(value = "totalBudget", required = false) Double totalBudget
    ) {
        return ResponseEntity.ok().body(countryBordersService.findAllBordersByCountry(startCountry));
    }

}
