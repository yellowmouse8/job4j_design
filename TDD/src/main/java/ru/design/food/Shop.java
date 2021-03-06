package ru.design.food;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shop implements Storage {

    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        this.foods.add(food);
    }

    @Override
    public List<Food> getList() {
        return foods;
    }

    @Override
    public boolean checkExpire(Food food, LocalDateTime current) {
        boolean result = false;
        double passed = Storage.duration(food.getCreateDate(), current);
        double leftover = Storage.duration(food.getCreateDate(), food.getExpaireDate());
        double expire = passed / leftover;
        if (expire >= Storage.lower && expire <= Storage.upper) {
            result = true;
        } else if (expire > Storage.upper && expire < 1) {
            food.setDisscount(Storage.discount);
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Shop";
    }
}
