package com.ua.bird_farm.services;


import com.ua.bird_farm.dao.entity.BirdEntity;
import com.ua.bird_farm.dao.entity.TypeBird;
import com.ua.bird_farm.dao.repository.BirdRepository;
import com.ua.bird_farm.dto.BirdDtoRequest;
import com.ua.bird_farm.dto.BirdDtoResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// priceDuck
// for 10 kg - price not change
// from 10 to 30 - price = price -1 per unit;
// from 30 to 50 - price = price -2 per unit;
@Service
@Transactional
@Log4j2
public class BirdServiceImpl implements BirdService {

    @Autowired
    private BirdRepository birdRepository;
//    @Autowired
//    private PriceService priceService;

    //+Todo Возможные типы птиц: индюк, утка, перепелка, курица.  Ограничить типы птиц либо кодом(возможно перечисления) либо базой данных(хард левел)
    //Todo сделать АПИ->Сервис который выводит все типы птиц, их остаток, цену за штуку и систеу скидок на каждый тип,
    //Todo вывести эти данные в джжейсоне

    //Todo переделать метод getBirdByTypeAndTotalWeight, прежде чем вывести информацию по запросу ,
    //Todo посмотреть наличие остатка и сранить запрашиваем количеством, если есть необходимый объем выдать его, а остаток уменьшить если нет броса исключение
    //Todo Продумать механизм общения по данному апи фермы и магазина

    //Todo переделать сервис расчета цены который зависит от типа птиц и уменьшать цену в процентах

    //Todo просчитать тотал сам?

    //Todo обратится к мастер гуглу,  ознакомится с bigDecimal, реализовать примеры.
    //Todo http://tutorials.jenkov.com/java-json/jackson-objectmapper.html пройти тутор повторить все примеры+усложнить.

    //Todo повторить кастомные Exception

    // Дабавить добавление птиц с интерфейсв
    // добавить информацию о ферме(птици, цена,какиескидки)

    //add to table birds
    private BirdEntity constructBirdEntityFromBirdDtoRequest(BirdDtoRequest birdDtoRequest) {
        BirdEntity birdEntity = null;
        if (TypeBird.findBirdType(birdDtoRequest.getType()) == true) {
            birdEntity = new BirdEntity();
            birdEntity.setWeight(birdDtoRequest.getWeight());
            birdEntity.setTotalWeight(birdDtoRequest.getWeight() + getTotalWeightByType(birdDtoRequest.getType()));
            birdEntity.setPricePerUnit(birdDtoRequest.getPricePerUnit());
            birdEntity.setBirdType(birdDtoRequest.getType());
            Date date = new Date();
            birdEntity.setDate(date);
            log.info(birdEntity);
        }
        else {
            System.out.println("error type");
        }
        return birdEntity;
    }

    private BirdDtoResponse constructBirdDtoResponseFromBirdEntity(BirdEntity birdEntity) {
        BirdDtoResponse birdDtoResponse = new BirdDtoResponse();
        birdDtoResponse.setPricePerUnit(birdEntity.getPricePerUnit());
        birdDtoResponse.setTotalWeight(birdEntity.getTotalWeight());
        birdDtoResponse.setType(birdEntity.getBirdType());
        birdDtoResponse.setWeight(birdEntity.getWeight());
        return birdDtoResponse;
    }

    public BirdDtoRequest addBirdDtoRequestToDB(BirdDtoRequest birdDtoRequest) {
        try {
            BirdEntity birdEntity = constructBirdEntityFromBirdDtoRequest(birdDtoRequest);
            birdRepository.saveAndFlush(birdEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return birdDtoRequest;
    }

    private double getTotalWeightByType(String type) {
        double weight = 0;
        if (birdRepository.findAllByMaxDateAndBirdType(type).size() == 0) {
        } else {
            ArrayList<BirdEntity> birdEntities = new ArrayList<>(birdRepository.findAllByMaxDateAndBirdType(type));
            weight = birdEntities.get(birdEntities.size()).getTotalWeight();
            System.out.println(weight);
        }
        return weight;
    }

    public List<BirdDtoResponse> findAllByBirdTypeAndMaxDate(String type) {
        List<BirdEntity> birdEntityList = birdRepository.findAllByMaxDateAndBirdType(type);
        List<BirdDtoResponse> birdDtoResponseList = new ArrayList<>();
        for (BirdEntity birdEntity : birdEntityList) {
            BirdDtoResponse birdDtoResponse = constructBirdDtoResponseFromBirdEntity(birdEntity);
            birdDtoResponseList.add(birdDtoResponse);
        }
        return birdDtoResponseList;
    }

}
