package ru.design.food;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public abstract class Food {
    private String name;
    private LocalDateTime expaireDate;
    private LocalDateTime createDate;
    private double price;
    private double disscount;

    public Food(String name, LocalDateTime createDate, LocalDateTime expaireDate, double price, double disscount) {
        this.name = name;
        this.createDate = createDate;
        this.expaireDate = expaireDate;
        this.price = price;
        this.disscount = disscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(LocalDateTime expaireDate) {
        this.expaireDate = expaireDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDisscount() {
        return disscount;
    }

    public void setDisscount(double disscount) {
        this.disscount = disscount;
    }


    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", createDate =" + createDate +
                ", expaireDate =" + expaireDate +
                ", price=" + price +
                ", disscount=" + disscount +
                '}';
    }
}
