package com.siliev.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TravelData {

    private String startCountry;
    private Double budgetPerCountry;
    private Double totalBudget;
}
