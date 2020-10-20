package com.siliev.services.impl;

import com.siliev.dto.LatestRateDto;
import com.siliev.entities.LatestRateEntity;
import com.siliev.properties.LatestRateProperties;
import com.siliev.repositories.LatestRateRepository;
import com.siliev.services.LatestRateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LatestRateServiceImpl implements LatestRateService {

    private final LatestRateProperties latestRateProperties;

    private final ModelMapper modelMapper;
    private final LatestRateRepository latestRateRepository;
    private final RestTemplate restTemplate;

    public LatestRateServiceImpl(LatestRateProperties latestRateProperties, ModelMapper modelMapper,
        LatestRateRepository latestRateRepository, RestTemplate restTemplate) {
        this.latestRateProperties = latestRateProperties;
        this.modelMapper = modelMapper;
        this.latestRateRepository = latestRateRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public LatestRateDto getCurrencyExchangeRate() {
        ResponseEntity<LatestRateDto> latestRate = restTemplate.getForEntity(latestRateProperties.getUrl(), LatestRateDto.class);
        return latestRate.getBody();
    }

    @Override
    public LatestRateDto findLatest() {
        return modelMapper.map(latestRateRepository.findLatest(), LatestRateDto.class);
    }

    @Override
    public LatestRateDto save(LatestRateDto latestRateDto) {
        LatestRateEntity latestRateEntity = latestRateRepository.save(modelMapper.map(latestRateDto, LatestRateEntity.class));
        return modelMapper.map(latestRateEntity, LatestRateDto.class);
    }
}
