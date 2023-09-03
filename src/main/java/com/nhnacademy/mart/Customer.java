package com.nhnacademy.mart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer {

    private static final Logger logger = LoggerFactory.getLogger(Customer.class);
    // 고객 구매 목록
    private final BuyList buyList;
    // 고객 장바구니
    private Basket basket;
    private Counter counter;
    private int cus_money = 0;

    public int getCus_money() {
        return cus_money;
    }

    public Customer(BuyList buyList) {
        this.buyList = buyList;

    }


    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }


    public void pickFoods(FoodStand foodStand){

        // 로그 : 넘겨받은 장바구니의 개수 확인
        logger.info("장바구니 상품 개수 : {}", buyList.getItems().size());
        for(BuyList.Item i : buyList.getItems()){
            String product = i.getName();
            int count = i.getAmount();

            int idx = 0;
            int price = 0;
            for(int j=0; j<foodStand.getFoods().size(); j++){
                if(idx == count) break;

                if(foodStand.getFoods().get(j).getName().equals(product)){
                    price = foodStand.getFoods().get(j).getPrice();
                    idx++;
                }
            }

            if(idx == 0)
                throw new IllegalArgumentException("존재하지 않는 상품 입니다");
            if(idx < count)
                throw new IllegalArgumentException("상품의 재고가 부족합니다.");

            for(int j=0; j<count; j++){
                foodStand.delete(new Food(product, price));
                basket.add(new Food(product, price));
            }

        }


    }

    public void payTox(Counter counter){
        this.counter = counter;


        cus_money = 20000;
        counter.pay(basket.getFoods(), cus_money);

        cus_money -= counter.getTotal_pay();

    }


}
