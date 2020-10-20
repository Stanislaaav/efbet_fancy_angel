package com.siliev.controllers;

import com.siliev.dto.CountryBordersDto;
import com.siliev.dto.InformationAboutTheTrip;
import com.siliev.dto.LatestRateDto;
import com.siliev.dto.TravelData;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcesing {

    public static InformationAboutTheTrip getInformationAboutTheTrip(
        TravelData travelData,
        List<CountryBordersDto> countryBordersDtos,
        LatestRateDto latestRateDto) {

        Double sumOfAllCountry = travelData.getBudgetPerCountry() * countryBordersDtos.size();
        Integer exactTimesTravelAroundCountry = (int) ((travelData.getTotalBudget() / (sumOfAllCountry)));

        return InformationAboutTheTrip.builder()
            .leftover(travelData.getTotalBudget() - (sumOfAllCountry * exactTimesTravelAroundCountry))
            .exactTimesTravelAroundCountry((exactTimesTravelAroundCountry))
            .borderCountryCurrencyRate(getBorderCountryCurrencyRate(travelData, countryBordersDtos, latestRateDto))
            .build();

    }

    private static Map<String, BigDecimal> getBorderCountryCurrencyRate(
        TravelData travelData,
        List<CountryBordersDto> countryBordersDtos,
        LatestRateDto latestRateDto) {

        Map<String, BigDecimal> borderCountryCurrencyRate = new HashMap<>();
        countryBordersDtos.forEach(country -> {

            if (country.getCountyCurrencyIsoCode() == null) {
                borderCountryCurrencyRate.put(country.getCountryBorderName(), BigDecimal.valueOf(travelData.getBudgetPerCountry()));
            } else {
                borderCountryCurrencyRate.put(country.getCountryBorderName(),
                    latestRateDto.getRates().get(country.getCountyCurrencyIsoCode()).multiply(BigDecimal.valueOf(travelData.getBudgetPerCountry())));
            }
        });

        return borderCountryCurrencyRate;
    }

}
