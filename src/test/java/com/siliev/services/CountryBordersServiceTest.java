package com.siliev.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.siliev.dto.CountryBordersDto;
import com.siliev.entities.CountryBordersEntity;
import com.siliev.repositories.CountryBordersRepository;
import com.siliev.services.impl.CountryBordersServiceImpl;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.web.client.RestTemplate;

@ExtendWith({MockitoExtension.class})
class CountryBordersServiceTest {

    @Mock
    private CountryBordersRepository countryBordersRepository;
    @Mock
    private RestTemplate restTemplate;
    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private CountryBordersServiceImpl countryBordersService;


    @Test
    void findAllBordersByCountry_andExpected_noErrors() {

        String country = "Bularia";

        List<CountryBordersEntity> response = Collections.singletonList(CountryBordersEntity.builder()
            .countryBorderCode("countryBorderCode")
            .countryBorderName("countryBorderName")
            .countryCode("countryCode")
            .countyCurrencyIsoCode("BGN")
            .build());

        when(countryBordersRepository.findAllByCountryName(any())).thenReturn(response);

        List<CountryBordersDto> result = countryBordersService.findAllBordersByCountry(country);

        assertEquals(1, result.size());
        assertEquals(response.get(0).getCountryBorderName(), result.get(0).getCountryBorderName());
        assertEquals(response.get(0).getCountryName(), result.get(0).getCountryName());
        assertEquals(response.get(0).getCountryCode(), result.get(0).getCountryCode());
        assertEquals(response.get(0).getCountryBorderCode(), result.get(0).getCountryBorderCode());
    }

    @Test
    void populateCountryBorders_andExpected_noErrors() {

        doNothing().when(countryBordersRepository).populateCountryBorders();
        countryBordersService.populateCountryBorders();
        verify(countryBordersRepository, times(1)).populateCountryBorders();
    }
}