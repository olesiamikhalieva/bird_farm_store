package com.ua.bird_farm.dao.entity;

import lombok.Getter;

import java.util.ArrayList;
@Getter
public enum TypeBird {
    TURKEY,
    DUCK,
    QUIAL,
    CHICKEN;

    public static boolean findBirdType(String type){
        boolean check=false;
        for (String s : enumIteration()) {
            if (s.equalsIgnoreCase(type)){
                check=true;
                System.out.println(s+"-"+type);
                return check;
            }
        }
        System.out.println("check"+check+"-"+type);
        return check;
    }

    public static ArrayList<String> enumIteration() {
        TypeBird[] typeBirdsList = TypeBird.values();
        ArrayList<String> typeBirds = new ArrayList<>();
        for (TypeBird type : typeBirdsList) {
            typeBirds.add(type.toString());
        }
        return typeBirds;
    }


}

