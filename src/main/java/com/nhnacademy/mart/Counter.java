package com.nhnacademy.mart;

import java.util.List;

public class Counter {

    private int total_pay;

    public int getTotal_pay() {
        return total_pay;
    }
    public void pay(List<Food> list, int cus_money){

        if(list.isEmpty())
            throw new IllegalArgumentException("장바구니가 비어있습니다.");

        total_pay = 0;
        for(Food food : list){
            total_pay += food.getPrice();
        }
        if(cus_money < total_pay)
            throw new IllegalArgumentException("한도 초과");


        System.out.println("총 가격은 " + total_pay + "원 입니다.");
        System.out.println("고객님 결제 후 잔액 : " + (cus_money -  total_pay));

    }


}
