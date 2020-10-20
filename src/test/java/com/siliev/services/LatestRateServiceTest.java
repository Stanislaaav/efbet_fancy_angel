package com.siliev.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.siliev.dto.LatestRateDto;
import com.siliev.entities.LatestRateEntity;
import com.siliev.properties.LatestRateProperties;
import com.siliev.repositories.LatestRateRepository;
import com.siliev.services.impl.LatestRateServiceImpl;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class LatestRateServiceTest {

    @Spy
    private ModelMapper modelMapper;
    @Mock
    private LatestRateRepository latestRateRepository;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private LatestRateProperties latestRateProperties;
    @InjectMocks
    private LatestRateServiceImpl latestRateService;

    @Test
    void findLatest_andExpected_noErrors() {

        Double budgetPerCountry = 444444.8;
        Double totalBudget = 555555.555;
        String country = "Bularia";
        String base = "base";
        Map<String, BigDecimal> map = Map.of("key", new BigDecimal(27));

        LatestRateEntity response = LatestRateEntity.builder()
            .date(new Date())
            .success(true)
            .timestamp(6564846516L)
            .rates(map)
            .base(base)
            .build();

        when(latestRateRepository.findLatest()).thenReturn(response);

        LatestRateDto result = latestRateService.findLatest();

        assertEquals(response.getBase(), result.getBase());
        assertEquals(response.getDate(), result.getDate());
        assertEquals(response.isSuccess(), result.isSuccess());
        assertEquals(response.getTimestamp(), result.getTimestamp());
        assertEquals(response.getRates(), result.getRates());
    }

    @Test
    void save_andExpected_noErrors() {

        String base = "base";

        Map<String, BigDecimal> map = Map.of("key", new BigDecimal(27));

        LatestRateDto request = LatestRateDto.builder()
            .date(new Date())
            .success(true)
            .timestamp(6564846516L)
            .rates(map)
            .base(base)
            .build();

        LatestRateEntity response = LatestRateEntity.builder()
            .date(new Date())
            .success(true)
            .timestamp(6564846516L)
            .rates(map)
            .base(base)
            .build();

        when(latestRateRepository.save(any())).thenReturn(response);

        LatestRateDto result = latestRateService.save(request);

        assertEquals(response.getRates(), result.getRates());
        assertEquals(response.getTimestamp(), result.getTimestamp());
        assertEquals(response.getDate(), result.getDate());
        assertEquals(response.getBase(), result.getBase());
        assertEquals(response.isSuccess(), result.isSuccess());
    }

    @Test
    void getCurrencyExchangeRate_andExpected_noErrors() {

        String url = "http://data.fixer.io/api/latest?access_key=b4f8f781116dbb552b7858e688117998&format=1";
        Map<String, BigDecimal> map = Map.of("key", new BigDecimal(27));

        LatestRateDto response = LatestRateDto.builder()
            .date(new Date())
            .success(true)
            .timestamp(6564846516L)
            .rates(map)
            .base(url)
            .build();

        when(latestRateProperties.getUrl()).thenReturn(url);
        when(restTemplate.getForEntity(url, LatestRateDto.class)).thenReturn(new ResponseEntity(response, HttpStatus.OK));
        LatestRateDto result = latestRateService.getCurrencyExchangeRate();

        assertEquals(response.getBase(), result.getBase());
        assertEquals(response.getDate(), result.getDate());
        assertEquals(response.getTimestamp(), result.getTimestamp());
        assertEquals(response.getRates(), result.getRates());
        assertEquals(response.isSuccess(), result.isSuccess());

    }
}