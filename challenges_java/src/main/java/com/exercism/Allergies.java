package com.exercism;

import java.util.ArrayList;
import java.util.List;

public class Allergies{

    List<Allergen> aList = new ArrayList<>();

    Allergies(int i){

        for (Allergen a : Allergen.values()){
            
            if (i >= a.getScore()){
                i -= a.getScore();
                aList.add(a);
            }
        }
    }

    Boolean isAllergicTo(Allergen a){
        return aList.contains(a);
    }

    List<Allergen> getList (){
        return aList;
    }
}

enum Allergen {
    CATS(128),
    POLLEN(64),
    CHOCOLATE(32),
    TOMATOES(16),
    STRAWBERRIES(8),
    SHELLFISH(4),
    PEANUTS(2),
    EGGS(1);

    private final int score;

    Allergen(int score) {
        this.score = score;
    }

    int getScore() {
        return score;
    }
}
