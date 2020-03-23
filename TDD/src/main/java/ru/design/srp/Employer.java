package ru.design.srp;

import java.util.Calendar;
import java.util.Objects;

public class Employer {
    private String name;
    private Calendar hired;
    private Calendar fired;
    private int salaryInt;
    private double salaryDouble;

    public Employer(String name, Calendar hired, Calendar fired, int salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salaryInt = salary;
    }

    public Employer(String name, double salaryDouble) {
        this.name = name;
        this.salaryDouble = salaryDouble;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getHired() {
        return hired;
    }

    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    public double getSalaryDouble() {
        return salaryDouble;
    }

    public void setSalaryDouble(double salaryDouble) {
        this.salaryDouble = salaryDouble;
    }

    public int getSalaryInt() {
        return salaryInt;
    }

    public void setSalaryInt(int salary) {
        this.salaryInt = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employer employer = (Employer) o;
        return Objects.equals(name, employer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Employer{"
                + "name='" + name + '\''
                + ", salary=" + salaryDouble
                + '}';
    }
}
