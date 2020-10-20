package com.siliev.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "currency.exchange.rate")
public class LatestRateProperties {

    private String url;

}
