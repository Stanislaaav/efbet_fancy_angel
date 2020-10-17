package com.siliev.services.impl;

import com.siliev.dto.CountryBordersDto;
import com.siliev.dto.LatestRateDto;
import com.siliev.repositories.CountryBordersRepository;
import com.siliev.services.CountryBordersService;
import com.siliev.services.LatestRateService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryBordersServiceImpl implements CountryBordersService {

    @Value("${currency.exchange.rate.url}")
    private String url;

    private final CountryBordersRepository countryBordersRepository;
    private final RestTemplate restTemplate;
    private final ModelMapper modelMapper;

    public CountryBordersServiceImpl(CountryBordersRepository countryBordersRepository,
        RestTemplate restTemplate, ModelMapper modelMapper, LatestRateService latestRateService) {
        this.countryBordersRepository = countryBordersRepository;
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CountryBordersDto> findAllBordersByCountry(String country) {

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map<String,Double> currencyExchangeRate = (Map<String, Double>) response.getBody().get("rates");

        return countryBordersRepository.findAllByCountryName(country).stream()
            .map(entity -> modelMapper.map(entity, CountryBordersDto.class))
            .collect(Collectors.toList());
    }

//    @Override
//    public LatestRateDto getCurrencyExchangeRate() {
//        ResponseEntity<LatestRateDto> latestRate = restTemplate.getForEntity(url, LatestRateDto.class);
//        return latestRate.getBody();
//    }
//
//    @Override
//    public LatestRateDto saveCurrencyExchangeRate() {
//        return latestRateService.save(getCurrencyExchangeRate());
//    }
}
