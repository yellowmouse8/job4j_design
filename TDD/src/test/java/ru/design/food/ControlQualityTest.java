package ru.design.food;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ControlQualityTest {
    private final LocalDateTime now = LocalDateTime.now();

    @Test
    public void setDiscount() {
        List<Storage> storages = new ArrayList<>();
        Shop shop = new Shop();
        storages.add(shop);
        ControlQuality controlQuality = new ControlQuality(storages);
        Fish fish = new Fish("Dorado", now.minusDays(10), now.plusDays(3), 200.00, 0.0);
        List<Food> foods = List.of(fish);
        Map<Storage, List<Food>> storage = controlQuality.distribute(foods, now);
        int countShop = 0;
        for (Map.Entry<Storage, List<Food>> entry : storage.entrySet()) {
            if (shop.equals(entry.getKey())) {
                countShop = entry.getValue().size();
            }
        }
        Double discount = storage.get(shop).get(0).getDisscount();
        assertThat(countShop, is(1));
        assertThat(discount, is(0.5));
    }

    @Test
    public void whenCheckControlQuality() {
        List<Storage> storages = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List.of(warehouse, shop, trash).stream().collect(Collectors.toCollection(() -> storages));
        ControlQuality controlQuality = new ControlQuality(storages);
        Fish fish = new Fish("Salmon", now.minusDays(6), now.minusDays(3), 200.00, 0.0);
        Fish fish1 = new Fish("Tuna", now.minusDays(8), now.minusDays(3), 250.00, 0.0);
        Cheese cheese = new Cheese("Chedder", now.minusDays(5), now.plusDays(25), 20.00, 0.0);
        Butter butter = new Butter("Natura", now.minusDays(8), now.plusDays(4), 15.00, 0.0);
        List<Food> foods = List.of(fish, fish1, cheese, butter);
        Map<Storage, List<Food>> storage = controlQuality.distribute(foods, now);
        System.out.println(storage);
        int countWarehouse = 0;
        int countShop = 0;
        int countTrash = 0;
        for (Map.Entry<Storage, List<Food>> entry : storage.entrySet()) {
            if (warehouse.equals(entry.getKey())) {
                countWarehouse = entry.getValue().size();
            }
            if (shop.equals(entry.getKey())) {
                countShop = entry.getValue().size();
            }
            if (trash.equals(entry.getKey())) {
                countTrash = entry.getValue().size();
            }
        }
        assertThat(countWarehouse, is(1));
        assertThat(countShop, is(1));
        assertThat(countTrash, is(2));
    }
}
