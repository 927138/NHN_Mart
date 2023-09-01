package com.nhnacademy.mart;

import java.util.List;

public class Counter {

    private int total_pay;
    public int pay(List<Food> list){
        total_pay = 0;
        for(Food food : list){
            total_pay += food.getPrice();
        }

        return total_pay;
    }


}
