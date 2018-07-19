package com.BuilderPattern.Builder;

import com.BuilderPattern.Entity.ChickenBurger;
import com.BuilderPattern.Entity.Coke;
import com.BuilderPattern.Entity.Pesi;
import com.BuilderPattern.Entity.VegBurger;

public class MealBulder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareChickenMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pesi());
        return meal;
    }
}
