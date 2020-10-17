package com.siliev.repositories;

import com.siliev.entities.LatestRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LatestRateRepository extends JpaRepository<LatestRateEntity,Long> {

}
