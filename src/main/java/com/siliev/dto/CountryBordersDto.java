package com.siliev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryBordersDto {

    private String countryCode;
    private String countryName;
    private String countryBorderCode;
    private String countryBorderName;

}
