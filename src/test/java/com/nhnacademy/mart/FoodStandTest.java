package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FoodStandTest {

    @Test
    @DisplayName("삭제 불가 상품")
    void delete() {
        FoodStand fs = new FoodStand();
        fs.add(new Food("양파", 2000));

        Assertions.assertThrows(IllegalArgumentException.class, ()->fs.delete(new Food("파", 500)));
    }

    @Test
    @DisplayName("success delete")
    void sdelete(){
        FoodStand fs = new FoodStand();
        fs.add(new Food("양파", 2000));

        fs.delete(new Food("양파", 2000));
        Assertions.assertEquals(0, fs.getFoods().size());
    }
}