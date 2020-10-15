package com.siliev.repositories;

import com.siliev.dto.CountryBordersDto;
import com.siliev.entities.CountryBordersEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryBordersRepository extends JpaRepository<CountryBordersEntity, String> {

    List<CountryBordersEntity> findAllByCountryName(String startCountry);
}
