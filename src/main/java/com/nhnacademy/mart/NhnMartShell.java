package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NhnMartShell {

    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);
    public static void main(String[] args) {
        System.out.println("NHN 마트에 오신 것을 환엽합니다.");
        System.out.print(" > ");
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        for(BuyList.Item i : buyList.getItems()){
            System.out.println(i);
        }

        Customer ji = new Customer(buyList);

        // 장바구니를 챙긴다.
        ji.bring(mart.provideBasket());

        // 식품을 담는다.
        ji.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        ji.payTox(mart.getCounter());


    }

    private static BuyList inputBuyListFromShell() {

        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int cnt;
        List<String> inputbuylist = new ArrayList<>();
        while (st.hasMoreTokens()){
            inputbuylist.add(st.nextToken());
        }

        if (inputbuylist.size() % 2 != 0) {
            throw new IllegalArgumentException("물건의 상품과 수량을 바르게 입력하세요.");
        }

        // 로그 : 입력받은 리스트 개수
        cnt = inputbuylist.size();
        logger.info("콘솔에서 입력받은 문자 토큰 개수 : {}", cnt);

        BuyList buyList = new BuyList();
        for(int i=0; i<cnt; i++){
            buyList.add(new BuyList.Item(inputbuylist.get(i), Integer.parseInt(inputbuylist.get(++i))));
        }

        // 로그 : 장바구니에 저장된 리수트 개수
        logger.info("buy list에 저장된 상품 개수 확인 : {}", buyList.getItems().size());

        //  입력과 저장이 다르면 error

        if(cnt/2 != buyList.getItems().size()) {
            logger.warn("입력과 저장이 동일하지 않음");
            throw new IllegalArgumentException("입력과 저장일 일치하지않음");
        }
        sc.close();

        return buyList;
    }
}
