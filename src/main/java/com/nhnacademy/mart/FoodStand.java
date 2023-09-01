package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.List;

public class FoodStand {

    private final ArrayList<Food> foods = new ArrayList<>();

    // TODO add 메서드 구현

    public void add(Food food){
        this.foods.add(food);
    }

    // TODO 장바구니에 담은 Food 삭제 구
    public void delete(Food food){
        this.foods.remove(food);
    }

    public List<Food> getFoods() {
        return foods;
    }


}
