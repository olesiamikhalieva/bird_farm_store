package com.ua.bird_farm.controller;


import com.ua.bird_farm.dao.entity.BirdFarmEntity;
import com.ua.bird_farm.dto.BirdDtoRequest;
import com.ua.bird_farm.dto.BirdDtoResponse;
import com.ua.bird_farm.services.BirdFarmService;
import com.ua.bird_farm.services.BirdService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/bird")
@Log4j2
public class BirdController {
    @Autowired
    private BirdFarmService birdFarmService;

    @GetMapping("get")
    public List<BirdDtoResponse> getAllBirds() {
        return birdFarmService.getAllBirdsDtoFromBirdsFarmTable();
    }

    @PostMapping("post")
    public String postAllBirds(@RequestBody BirdDtoRequest birdDtoRequest){
        birdFarmService.addBirdDtoRequestToDB(birdDtoRequest);
        return  "ok";
    }




}
