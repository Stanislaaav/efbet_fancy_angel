package com.siliev.services;

import com.siliev.dto.LatestRateDto;

public interface LatestRateService {

    LatestRateDto findLatest();

    LatestRateDto save(LatestRateDto latestRateDto);

    LatestRateDto getCurrencyExchangeRate();
}
