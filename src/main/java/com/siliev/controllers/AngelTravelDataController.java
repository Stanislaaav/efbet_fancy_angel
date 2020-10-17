package com.siliev.controllers;

import com.siliev.config.TEST;
import com.siliev.dto.CountryBordersDto;
import com.siliev.dto.LatestRateDto;
import com.siliev.enums.CurrenciesOfTheWorldEnum;
import com.siliev.repositories.CountryBordersRepository;
import com.siliev.services.CountryBordersService;
import com.siliev.services.LatestRateService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/travel/angel")
public class AngelTravelDataController {

    private final CountryBordersService countryBordersService;
    private final LatestRateService latestRateService;
    private final CountryBordersRepository countryBordersRepository;

    public AngelTravelDataController(CountryBordersService countryBordersService, LatestRateService latestRateService,
        CountryBordersRepository countryBordersRepository) {
        this.countryBordersService = countryBordersService;
        this.latestRateService = latestRateService;
        this.countryBordersRepository = countryBordersRepository;
    }

    @GetMapping("/data")
    public ResponseEntity<List<CountryBordersDto>> getInformationAboutTraveling(
        @RequestParam(value = "startCountry") String startCountry,
        @RequestParam(value = "budgetPerCountry", required = false) Double budgetPerCountry,
        @RequestParam(value = "totalBudget", required = false) Double totalBudget
    ) {

        List<CountryBordersDto> countryBordersDtos = countryBordersService.findAllBordersByCountry(startCountry);

        //countryBordersDtos.stream().map(coutryBorderName -> coutryBorderName.)

        return ResponseEntity.ok().body(countryBordersService.findAllBordersByCountry(startCountry));
    }



    @GetMapping("/dat")
    public ResponseEntity<Void> put() {

        TEST test = new TEST();

//        Map<CurrenciesOfTheWorldEnum,String> map = Arrays.stream(CurrenciesOfTheWorldEnum.values())
//            .collect(Collectors.toMap(Function.identity(), CurrenciesOfTheWorldEnum::getCode));

        for (Map.Entry<String, String> entry : test.getMap().entrySet()) {
           //System.out.println(entry.getKey() + ":" + entry.getValue());

            try {
                countryBordersRepository.insertIntoTable(entry.getValue(), entry.getKey());
            } catch (Exception e) {
                continue;
            }

        }

        //countryBordersRepository.insertIntoTable()

        return ResponseEntity.ok().build();
    }


    @PostMapping("/getCurrencyRate")
    public ResponseEntity<LatestRateDto> getCurrencyRate(@RequestBody LatestRateDto latestRateDto) {

        return ResponseEntity.ok().body(latestRateService.save(latestRateService.getCurrencyExchangeRate()));
    }
}
