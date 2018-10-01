package com.ua.bird_farm.dao.repository;

import com.ua.bird_farm.dao.entity.BirdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BirdRepository extends JpaRepository<BirdEntity, Long> {


    @Query("SELECT b, max (b.date)FROM BirdEntity b WHERE b.birdType=?1 group by b.id")
    List<BirdEntity> findAllByMaxDateAndBirdType(String birdType);

}
