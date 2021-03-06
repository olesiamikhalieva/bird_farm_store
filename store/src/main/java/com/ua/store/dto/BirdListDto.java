package com.ua.store.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BirdListDto implements Serializable {

    @JsonProperty("bird_list")
    List<BirdDto> birdDtoList;
}
