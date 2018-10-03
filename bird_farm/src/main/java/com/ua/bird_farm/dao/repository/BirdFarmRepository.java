package com.ua.bird_farm.dao.repository;

import com.ua.bird_farm.dao.entity.BirdFarmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface BirdFarmRepository extends JpaRepository<BirdFarmEntity, Long> {
    BirdFarmEntity findBirdFarmEntityByBirdTypeAndPricePerUnit(String type, BigDecimal price);
}
