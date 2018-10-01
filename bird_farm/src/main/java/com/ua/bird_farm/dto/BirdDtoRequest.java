package com.ua.bird_farm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class BirdDtoRequest {

    @JsonProperty
    private String type;
    @JsonProperty
    private BigDecimal pricePerUnit;
    @JsonProperty
    private double weight;
}
