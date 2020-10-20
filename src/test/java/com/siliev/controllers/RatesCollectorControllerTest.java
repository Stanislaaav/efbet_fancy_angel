package com.siliev.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siliev.controllers.impl.RatesCollectorControllerImpl;
import com.siliev.dto.CountryBordersDto;
import com.siliev.dto.LatestRateDto;
import com.siliev.dto.TravelData;
import com.siliev.services.CountryBordersService;
import com.siliev.services.LatestRateService;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {RatesCollectorController.class})
@AutoConfigureMockMvc(addFilters = false)
class RatesCollectorControllerTest {

    private static final String BASE_CONTROLLER_PATH = "/api/travel/angel";
    @Autowired
    protected MockMvc mockMvc;
    @MockBean
    private CountryBordersService countryBordersService;
    @MockBean
    private LatestRateService latestRateService;
    @Mock
    private DataProcesing dataProcesing;
    @MockBean
    private LatestRateDto latestRateDto;
    @InjectMocks
    private RatesCollectorControllerImpl ratesCollectorController;

    @Test
    void getInformationAboutTraveling() throws Exception {

        Double budgetPerCountry = 444444.8;
        Double totalBudget = 555555.555;
        String country = "Bularia";
        String base = "base";

        TravelData travelData = TravelData.builder()
            .budgetPerCountry(budgetPerCountry)
            .totalBudget(totalBudget)
            .startCountry(country)
            .build();

        Map<String, BigDecimal> map = Map.of("BGN", new BigDecimal(27));

        LatestRateDto latestRateDto = LatestRateDto.builder()
            .date(new Date())
            .success(true)
            .timestamp(6564846516L)
            .rates(map)
            .base(base)
            .build();

        List<CountryBordersDto> countryBordersDtos = Collections.singletonList(CountryBordersDto.builder()
            .countryBorderCode("countryBorderCode")
            .countryBorderName("countryBorderName")
            .countryCode("countryCode")
            .countyCurrencyIsoCode("BGN")
            .build());

        when(countryBordersService.findAllBordersByCountry(country)).thenReturn(countryBordersDtos);
        when(latestRateService.findLatest()).thenReturn(latestRateDto);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(travelData);

        mockMvc.perform(
            post(BASE_CONTROLLER_PATH + "/information")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andDo(print())
            .andExpect(jsonPath("$").exists())
            .andExpect(status().isOk());
    }
}