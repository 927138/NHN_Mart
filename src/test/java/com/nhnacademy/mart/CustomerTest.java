package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    @DisplayName("입력 상품이 없는 경우")
    void product_isEmpty(){
        FoodStand fs = new FoodStand();
        fs.add(new Food("apple", 1000));
        fs.add(new Food("apple", 1000));

        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("배", 2));

        Assertions.assertThrows(IllegalArgumentException.class, ()->new Customer(buyList).pickFoods(fs));
    }

    @Test
    @DisplayName("상품의 재고가 없는 경우")
    void product_over(){
        FoodStand fs = new FoodStand();
        fs.add(new Food("apple", 1000));
        fs.add(new Food("apple", 1000));

        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("apple", 5));

        Assertions.assertThrows(IllegalArgumentException.class, ()->new Customer(buyList).pickFoods(fs));
    }

    @Test
    @DisplayName("상품의 가격이 소유 자산을 넘을때")
    void over_money(){
        FoodStand fs = new FoodStand();
        fs.add(new Food("apple", 50000));

        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("apple", 5));

        // default 20000won
        Assertions.assertThrows(IllegalArgumentException.class, ()->new Customer(buyList).pickFoods(fs));
    }

    @Test
    @DisplayName("거스름돈 check")
    void money_change(){
        FoodStand fs = new FoodStand();
        fs.add(new Food("apple", 2000));

        BuyList buyList = new BuyList();
        buyList.add(new BuyList.Item("apple", 1));


        Customer customer = new Customer(buyList);
        customer.bring(new Basket());
        customer.pickFoods(fs);
        customer.payTox(new Counter());

        // default 20000won
        Assertions.assertEquals(18000, customer.getCus_money());
    }

    @Test
    @DisplayName("basket 클래스가 null")
    void basket_null(){
        Customer customer = new Customer(new BuyList());

        Assertions.assertThrows(NullPointerException.class, ()->customer.payTox(new Counter()));
    }
}