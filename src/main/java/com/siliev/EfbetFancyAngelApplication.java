package com.siliev;

import com.siliev.properties.LatestRateProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({LatestRateProperties.class})
public class EfbetFancyAngelApplication {

    public static void main(String[] args) {
        SpringApplication.run(EfbetFancyAngelApplication.class, args);
    }

}
