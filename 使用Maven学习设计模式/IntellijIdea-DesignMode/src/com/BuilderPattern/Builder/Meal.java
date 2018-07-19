package com.BuilderPattern.Builder;

import com.BuilderPattern.Interface.Item;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> lists = new ArrayList<Item>();

    public void addItem(Item item) {
        lists.add(item);
    }

    public float getAllCodts() {
        float allCost = 0;
        for (Item item : lists) {
            allCost += item.price();
        }
        return allCost;
    }

    public void ShowAllItems() {
        for (Item item : lists) {
            System.out.println(item.name() + " " + item.packing().packing() + " " + item.price());
        }
    }

}
