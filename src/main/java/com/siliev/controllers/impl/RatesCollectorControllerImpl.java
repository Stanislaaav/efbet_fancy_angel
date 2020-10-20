package com.siliev.controllers.impl;

import com.siliev.controllers.DataProcesing;
import com.siliev.controllers.RatesCollectorController;
import com.siliev.dto.InformationAboutTheTrip;
import com.siliev.dto.TravelData;
import com.siliev.services.CountryBordersService;
import com.siliev.services.LatestRateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatesCollectorControllerImpl implements RatesCollectorController {

    private final CountryBordersService countryBordersService;
    private final LatestRateService latestRateService;

    public RatesCollectorControllerImpl(CountryBordersService countryBordersService, LatestRateService latestRateService) {
        this.countryBordersService = countryBordersService;
        this.latestRateService = latestRateService;
    }

    @Override
    public ResponseEntity<InformationAboutTheTrip> getInformationAboutTraveling(TravelData travelData) {

        return ResponseEntity.ok().body(DataProcesing.getInformationAboutTheTrip(
            travelData,
            countryBordersService.findAllBordersByCountry(travelData.getStartCountry()),
            latestRateService.findLatest()));
    }

    public String restricted() {
        return "To see this text you need to be logged in!";
    }

}
