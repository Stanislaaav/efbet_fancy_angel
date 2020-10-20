package com.siliev.dto;

import java.math.BigDecimal;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class InformationAboutTheTrip {

    private Integer exactTimesTravelAroundCountry;
    private Double leftover;
    private Map<String, BigDecimal> borderCountryCurrencyRate;

}
