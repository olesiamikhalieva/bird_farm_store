package com.ua.bird_farm.services;

import com.ua.bird_farm.dao.entity.BirdFarmEntity;
import com.ua.bird_farm.check.TypeBird;
import com.ua.bird_farm.dao.repository.BirdFarmRepository;
import com.ua.bird_farm.dto.BirdDtoRequest;
import com.ua.bird_farm.dto.BirdDtoResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@Transactional
public class BirdFarmService {
    @Autowired
    private BirdFarmRepository birdFarmRepository;
    @Autowired
    private BirdServiceImpl birdService;
    @Autowired
    private PriceService priceService;


    public void addBirdDtoRequestToDB(BirdDtoRequest birdDtoRequest) {
        if (TypeBird.findBirdType(birdDtoRequest.getType()) == true) {
            System.out.println("bedin method add");
            birdService.addBirdDtoRequestToTableBirdsStatistic(birdDtoRequest);
            System.out.println("add to birdStatistic");
            addBirdDtoRequestToTableBirdsFarm(birdDtoRequest);
        } else {
            System.out.println("error type");
        }
    }

    private BirdFarmEntity constructBirdFarmEntityFromBirdDtoRequest(BirdDtoRequest birdDtoRequest) {
        BirdFarmEntity birdFarmEntity = birdFarmRepository.findBirdFarmEntityByBirdTypeAndPricePerUnit(birdDtoRequest.getType(),birdDtoRequest.getPricePerUnit());
        if (birdFarmEntity == null) {
            birdFarmEntity = new BirdFarmEntity();
            birdFarmEntity.setTotalWeight(birdDtoRequest.getWeight());
            birdFarmEntity.setPricePerUnit(birdDtoRequest.getPricePerUnit());
            birdFarmEntity.setBirdType(birdDtoRequest.getType());
        } else {
            birdFarmEntity.setTotalWeight(birdDtoRequest.getWeight() + birdFarmEntity.getTotalWeight());
        }

        log.info(birdFarmEntity);
        return birdFarmEntity;
    }

    private BirdDtoRequest addBirdDtoRequestToTableBirdsFarm(BirdDtoRequest birdDtoRequest) {
        try {
            BirdFarmEntity birdFarmEntity = constructBirdFarmEntityFromBirdDtoRequest(birdDtoRequest);
            birdFarmRepository.saveAndFlush(birdFarmEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return birdDtoRequest;
    }

    private BirdDtoResponse constructBirdDtoResponseFromBirdEntity(BirdFarmEntity birdFarmEntity) {
        BirdDtoResponse birdDtoResponse = new BirdDtoResponse();
        birdDtoResponse.setPricePerUnit(birdFarmEntity.getPricePerUnit());
        birdDtoResponse.setType(birdFarmEntity.getBirdType());
        birdDtoResponse.setWeight(birdFarmEntity.getTotalWeight());
        return birdDtoResponse;
    }

    public List<BirdDtoResponse> getAllBirdsDtoFromBirdsFarmTable(){
        List<BirdDtoResponse> birdDtoResponseList = new ArrayList<>();
        for (BirdFarmEntity birdFarmEntity : birdFarmRepository.findAll()) {
            BirdDtoResponse birdDtoResponse = constructBirdDtoResponseFromBirdEntity(birdFarmEntity);
            birdDtoResponseList.add(birdDtoResponse);
        }
        return birdDtoResponseList;
    }

}
