package ru.design.food;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Butter extends Food {

    public Butter(String name, LocalDateTime createDate, LocalDateTime expaireDate, double price, double disscount) {
        super(name, createDate, expaireDate, price, disscount);
    }
}
