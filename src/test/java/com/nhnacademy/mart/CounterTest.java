package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CounterTest {

    @Test
    @DisplayName("장바구니가 비어잇음")
    void buylist_isEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Counter().pay(new Basket().getFoods(), 5000));
    }

    @Test
    @DisplayName("한도 초과")
    void over_money(){
        Basket basket =  new Basket();
        basket.add(new Food("양파", 2000));

        Assertions.assertThrows(IllegalArgumentException.class, ()->new Counter().pay(basket.getFoods(), 1000));
    }

    @Test
    @DisplayName("정상 거래")
    void succes_pay(){
        FoodStand fs = new FoodStand();
        fs.add(new Food("양파", 2000));
        fs.add(new Food("양파", 2000));

        Basket basket =  new Basket();
        basket.add(new Food("양파", 2000));
        basket.add(new Food("양파", 2000));


        Counter counter = new Counter();
        counter.pay(basket.getFoods(), 5000);

        Assertions.assertEquals(4000, counter.getTotal());
    }




}