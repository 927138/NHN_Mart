package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.List;

public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();


    public void add(Food food){
        foods.add(food);
    }

    public void delete(Food food){
        if(!foods.contains(food)){
            throw new IllegalArgumentException("존재하지 않는 상품");
        }
        foods.remove(food);
    }

    public List<Food> getFoods() {
        return foods;
    }


}
