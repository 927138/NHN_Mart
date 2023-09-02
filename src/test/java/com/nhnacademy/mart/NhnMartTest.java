package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NhnMartTest {

    @Test
    @DisplayName("마트에 상품이 존재하지 않은 경우")
    void getFoodStand() {

        Assertions.assertThrows(IllegalArgumentException.class, ()->new NhnMart().getFoodStand());
    }
}