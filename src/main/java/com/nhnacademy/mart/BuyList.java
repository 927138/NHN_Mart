package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.List;

public class BuyList {

    private final ArrayList<Item> items = new ArrayList<>();

    // TODO add 메서드 생성

    void add(Item item){
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }


    public static class Item {
        private final String name;
        private final int amount;

        Item(String name, int amount){
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

}
