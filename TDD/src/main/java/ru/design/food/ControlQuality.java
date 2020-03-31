package ru.design.food;

import java.time.LocalDateTime;
import java.util.*;

public class ControlQuality {
    private List<Storage> storages;
    private Map<Storage, List<Food>> foodMap = new HashMap<>();

    public ControlQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void load(Storage storage) {
        this.storages.add(storage);
    }

    public Map<Storage, List<Food>> distribute(List<Food> foods, LocalDateTime current) {
        foods.forEach(f -> load(f, current));
        storages.forEach(s -> foodMap.put(s, s.getList()));
        return foodMap;
    }

    private void load(Food food, LocalDateTime current) {
        for (Storage s : storages) {
            if (s.checkExpire(food, current)) {
                s.add(food);
                break;
            }
        }
    }
}
