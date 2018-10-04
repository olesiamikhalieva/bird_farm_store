package com.ua.bird_farm.controller;

import com.ua.bird_farm.dto.BirdDtoRequest;
import com.ua.bird_farm.services.BirdFarmService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@Log4j2
@RequestMapping("/bird")
public class BirdController {
        @Autowired
        private BirdFarmService birdFarmService;

        @GetMapping("/all")
        public String mainMethod(Model model) {
            log.info("in controller");
            model.addAttribute("birdList", birdFarmService.getAllBirdsDtoFromBirdsFarmTable());
            return "index";
        }

        @RequestMapping("/add")
        public String addBird(@ModelAttribute("bird") BirdDtoRequest birdDtoRequest) {
                birdFarmService.addBirdDtoRequestToDB(birdDtoRequest);
                 log.info(birdDtoRequest.toString());
                return "redirect:/bird/all";

    }
}
