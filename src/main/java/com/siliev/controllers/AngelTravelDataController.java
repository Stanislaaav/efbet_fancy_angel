package com.siliev.controllers;

import com.siliev.dto.CountryBordersDto;
import com.siliev.services.CountryBordersService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/travel/angel")
public class AngelTravelDataController {

    @Value("${currency.exchange.rate.url}")
    private String url;

    private final CountryBordersService countryBordersService;
    private final RestTemplate restTemplate;

    public AngelTravelDataController(CountryBordersService countryBordersService, RestTemplate restTemplate) {
        this.countryBordersService = countryBordersService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/data")
    public ResponseEntity<List<CountryBordersDto>> getInformationAboutTraveling(
        @RequestParam(value = "startCountry") String startCountry,
        @RequestParam(value = "budgetPerCountry", required = false) Double budgetPerCountry,
        @RequestParam(value = "totalBudget", required = false) Double totalBudget
    ) {

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        Map<String,Double> currencyExchangeRate = (Map<String, Double>) response.getBody().get("rates");

        return ResponseEntity.ok().body(countryBordersService.findAllBordersByCountry(startCountry));
    }

}
