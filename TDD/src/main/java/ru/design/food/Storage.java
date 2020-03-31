package ru.design.food;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public interface Storage {
    double lower = 0.25;
    double upper = 0.75;
    double discount = 0.50;

    boolean checkExpire(Food food, LocalDateTime current);

    static long duration(LocalDateTime first, LocalDateTime second) {
        return Duration.between(first, second).toMillis();
    }

    List<Food> getList();

    void add(Food food);
}
