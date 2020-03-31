package ru.design.food;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Cheese extends Food {
    public Cheese(String name, LocalDateTime createDate, LocalDateTime expaireDate, double price, double disscount) {
        super(name, createDate, expaireDate, price, disscount);
    }
}
