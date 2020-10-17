package com.siliev.services.impl;

import com.siliev.dto.LatestRateDto;
import com.siliev.entities.LatestRateEntity;
import com.siliev.repositories.LatestRateRepository;
import com.siliev.services.LatestRateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LatestRateServiceImpl implements LatestRateService {

    @Value("${currency.exchange.rate.url}")
    private String url;

    private final ModelMapper modelMapper;
    private final LatestRateRepository latestRateRepository;
    private final RestTemplate restTemplate;

    public LatestRateServiceImpl(ModelMapper modelMapper, LatestRateRepository latestRateRepository, RestTemplate restTemplate) {
        this.modelMapper = modelMapper;
        this.latestRateRepository = latestRateRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public LatestRateDto getCurrencyExchangeRate() {
        ResponseEntity<LatestRateDto> latestRate = restTemplate.getForEntity(url, LatestRateDto.class);
        return latestRate.getBody();
    }

    @Override
    public LatestRateDto save(LatestRateDto latestRateDto) {
        LatestRateEntity latestRateEntity = latestRateRepository.save(modelMapper.map(latestRateDto, LatestRateEntity.class));
        return modelMapper.map(latestRateEntity, LatestRateDto.class);
    }
}
