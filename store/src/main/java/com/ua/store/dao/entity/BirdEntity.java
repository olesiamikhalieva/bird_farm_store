package com.ua.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Table(name = "bird_in_magaz")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BirdEntityInMagaz {

    @javax.persistence.Id
    @GeneratedValue
    private long Id;
    @Column
    private String birdType;
    @Column
    private int pricePerUnit;
    @Column
    private int weight;


}
