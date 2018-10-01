package com.ua.bird_farm.services;


import com.ua.bird_farm.dto.BirdDtoRequest;
import com.ua.bird_farm.dto.BirdDtoResponse;

import java.util.List;

public interface BirdService {

   // Дабавить добавление птиц с интерфейсв
   // добавить информацию о ферме(птици, цена,какиескидки)
   //BirdDtoResponse getBirdDtoByTypeAndWeight(PriceBirdEntity birdEntity, double weight);
   BirdDtoRequest addBirdDtoRequestToDB(BirdDtoRequest birdDtoRequest);
   List<BirdDtoResponse> findAllByBirdTypeAndMaxDate(String type);
}
