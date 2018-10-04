package com.ua.bird_farm.services;

import com.ua.bird_farm.check.TypeBird;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
// price
// for 10 kg - price not change
// from 10 to 30 - price = price -5 percent per unit;
// from 30 to 50 - price = price -10 percent per unit;

public class PriceService {
    @Value("${price.duck}")
    private BigDecimal priceDuck;
    @Value("${price.chicken}")
    private BigDecimal priceChicken;
    @Value("${price.quial}")
    private BigDecimal priceQuial;
    @Value("${price.turkey}")
    private BigDecimal priceTurkey;
    @Value("${price.surcharge}")
    private double priceSurchargePerUnit;


    private double saleFrom10to30Weight = 5;//persent
    private double saleFrom50Weight = 10;//persent

    public BigDecimal checkPriceByWeight(double weight, String type) {
        BigDecimal newPrice = null;
        if (type.equals(TypeBird.CHICKEN)) {
            if ((weight >= 10) && (weight < 30)) {
                newPrice = priceChicken.multiply(BigDecimal.valueOf(weight)).multiply(BigDecimal.valueOf(1 - saleFrom10to30Weight / 100));
            } else if (weight >= 50) {
                newPrice = priceChicken.multiply(BigDecimal.valueOf(weight)).multiply(BigDecimal.valueOf(1 - saleFrom50Weight / 100));
            }
        }
        if (type.equals(TypeBird.TURKEY)) {
            if ((weight >= 10) && (weight < 30)) {
                newPrice = priceTurkey.multiply(BigDecimal.valueOf(weight)).multiply(BigDecimal.valueOf(1 - saleFrom10to30Weight / 100));
            } else if (weight >= 50) {
                newPrice = priceTurkey.multiply(BigDecimal.valueOf(weight)).multiply(BigDecimal.valueOf(1 - saleFrom50Weight / 100));
            }
        }
        if (type.equals(TypeBird.DUCK)) {
            if ((weight >= 10) && (weight < 30)) {
                newPrice = priceDuck.multiply(BigDecimal.valueOf(weight)).multiply(BigDecimal.valueOf(1 - saleFrom10to30Weight / 100));
            } else if (weight >= 50) {
                newPrice = priceDuck.multiply(BigDecimal.valueOf(weight)).multiply(BigDecimal.valueOf(1 - saleFrom50Weight / 100));
            }
        }
        if (type.equals(TypeBird.QUIAL)) {
            if ((weight >= 10) && (weight < 30)) {
                newPrice = priceQuial.multiply(BigDecimal.valueOf(weight)).multiply(BigDecimal.valueOf(1 - saleFrom10to30Weight / 100));
            } else if (weight >= 50) {
                newPrice = priceQuial.multiply(BigDecimal.valueOf(weight)).multiply(BigDecimal.valueOf(1 - saleFrom50Weight / 100));
            }
        }
        return newPrice;
    }

}
