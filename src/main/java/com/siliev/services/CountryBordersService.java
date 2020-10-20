package com.siliev.services;

import com.siliev.dto.CountryBordersDto;
import java.util.List;

public interface CountryBordersService {

    List<CountryBordersDto> findAllBordersByCountry(String country);

    void populateCountryBorders();
}
