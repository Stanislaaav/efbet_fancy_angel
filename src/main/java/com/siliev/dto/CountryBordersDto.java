package com.siliev.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryBordersDto {

    private String countryCode;
    private String countryName;
    private String countryBorderCode;
    private String countryBorderName;
    private String countyCurrencyIsoCode;

}
