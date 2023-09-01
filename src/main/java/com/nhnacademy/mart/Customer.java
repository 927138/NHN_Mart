package com.nhnacademy.mart;

public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;
    // 고객 장바구니
    private Basket basket;
    private Counter counter;

    public Customer(BuyList buyList) {
        this.buyList = buyList;

    }


    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }


    // TODO pickFoods 메서드 구현
    // 장비구니에 있는 리스트를 바켓에 담기
    // buylist 어떻게 들고올건지
    // 수량이 없을때
    public void pickFoods(FoodStand foodStand){

        // 로그 : 넘겨받은 장바구니의 개수 확인
        System.out.println("고객 장바구니 개수 : " + buyList.getItems().size());
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

            if(idx == 0) throw new IllegalArgumentException("존재하지 않는 상품 입니다");
            if(idx < count) throw new IllegalArgumentException("상품의 재고가 부족합니다.");

            for(int j=0; j<count; j++){
                foodStand.delete(new Food(product, price));
                basket.add(new Food(product, price));
            }

        }

        System.out.println("-------------");
        for(Food food : foodStand.getFoods()){
            System.out.println(food);
        }

    }

    // TODO payTox 메서드 구현
    public void payTox(Counter counter){
        this.counter = counter;

        int cus_money = 20000;
        int total_pay = counter.pay(basket.getFoods());

        if(cus_money < total_pay) throw new IllegalArgumentException("한도 초과");
        System.out.println("총 가격은 " + total_pay + "원 입니다.");
        System.out.println("고객님 결제 후 잔액 : " + (cus_money -  total_pay));

    }

}
