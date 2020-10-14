package com.siliev.repositories;

import com.siliev.entities.CountryBorders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryBordersRepository extends JpaRepository<CountryBorders, Long> {

}
