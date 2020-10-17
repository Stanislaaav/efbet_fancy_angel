package com.siliev.repositories;

import com.siliev.entities.CountryBordersEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryBordersRepository extends JpaRepository<CountryBordersEntity, String> {

    List<CountryBordersEntity> findAllByCountryName(String startCountry);

    @Modifying
    @Query(value = "UPDATE country_borders SET county_currency_iso_code = ?1 WHERE country_border_name = ?2", nativeQuery = true)
    void insertIntoTable(String county_currency_iso_code, String country_border_name);

}
