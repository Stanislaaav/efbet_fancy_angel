package com.siliev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AngelTravelData {

    private String startCountry;
    private Double budgetPerCountry;
    private Double totalBudget;
}
