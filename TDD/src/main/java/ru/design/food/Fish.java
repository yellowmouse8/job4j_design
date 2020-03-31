package ru.design.food;

import java.time.LocalDateTime;
import java.util.Date;

public class Fish extends Food {
    public Fish(String name, LocalDateTime createDate, LocalDateTime expaireDate, double price, double disscount) {
        super(name, createDate, expaireDate, price, disscount);
    }
}
