package com.siliev.services;

import com.siliev.dto.LatestRateDto;

public interface LatestRateService {

    LatestRateDto save(LatestRateDto latestRateDto);

    LatestRateDto getCurrencyExchangeRate();
}
