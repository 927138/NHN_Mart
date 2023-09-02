package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NhnMartTest {

    @Test
    @DisplayName("마트에 상품이 존재하지 않은 경우")
    void getFoodStand_error() {

        Assertions.assertThrows(IllegalArgumentException.class, ()->new NhnMart().getFoodStand());
    }

    @Test
    @DisplayName("푸드 스탠드에 상품이 존재 하는경우")
    void getFoodStand(){
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        Assertions.assertNotNull(mart.getFoodStand());
    }
}