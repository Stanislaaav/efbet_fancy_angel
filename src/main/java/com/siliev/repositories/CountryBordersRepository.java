package com.siliev.repositories;

import com.siliev.entities.CountryBordersEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryBordersRepository extends JpaRepository<CountryBordersEntity, String> {

    List<CountryBordersEntity> findAllByCountryName(String startCountry);

    //TODO
    @Query(value = "COPY public.country_borders(\n"
        + "\tcountry_code, country_name, country_border_code, country_border_name)\n"
        + "FROM 'src/main/resources/country-borders/COUNTRY-BORDERS.CSV'\n"
        + "DELIMITER ','\n"
        + "CSV HEADER", nativeQuery = true)
    void populateCountryBorders();

}
