package com.ua.bird_farm.dao.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Setter
@Getter
@Entity
@ToString
@Table(name = "birds")
public class BirdEntity {
    @Id
    @GeneratedValue
    private long Id;
    @Column
    private String birdType;
    @Column
    private BigDecimal pricePerUnit;
    @Column
    private double weight;
    @Column
    private double TotalWeight;
    @Column
    private Date date;

}
