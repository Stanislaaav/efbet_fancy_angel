package com.siliev;

import com.siliev.properties.LatestRateProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({LatestRateProperty.class})
public class EfbetFancyAngelApplication {

    public static void main(String[] args) {
        SpringApplication.run(EfbetFancyAngelApplication.class, args);
    }

}
