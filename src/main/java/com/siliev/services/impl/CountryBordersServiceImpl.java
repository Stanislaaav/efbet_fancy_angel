package com.siliev.services.impl;

import com.siliev.dto.CountryBordersDto;
import com.siliev.repositories.CountryBordersRepository;
import com.siliev.services.CountryBordersService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CountryBordersServiceImpl implements CountryBordersService {

    private final CountryBordersRepository countryBordersRepository;

    private final ModelMapper modelMapper;

    public CountryBordersServiceImpl(CountryBordersRepository countryBordersRepository,
        ModelMapper modelMapper) {
        this.countryBordersRepository = countryBordersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CountryBordersDto> findAllBordersByCountry(String country) {
        return countryBordersRepository.findAllByCountryName(country).stream()
            .map(e -> modelMapper.map(e, CountryBordersDto.class))
            .collect(Collectors.toList());
    }
}
