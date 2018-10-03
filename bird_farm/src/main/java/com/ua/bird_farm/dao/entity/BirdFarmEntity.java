package com.ua.bird_farm.dao.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.math.BigDecimal;
    @Data
    @Setter
    @Getter
    @Entity
    @ToString
    @Table(name = "birds_farm")
    public class BirdFarmEntity {
        @javax.persistence.Id
        @GeneratedValue
        private long Id;
        @Column
        private String birdType;
        @Column
        private BigDecimal pricePerUnit;
        @Column
        private double TotalWeight;

}
