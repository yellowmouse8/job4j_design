package ru.design.srp;

import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.lang.reflect.Type;
import java.util.*;

public class ReportEngineTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalaryDouble()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenSalaryTypeInt() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employer worker = new Employer("Fedor", now, now, 2500);
        store.add(worker);
        int intType = 2500;
        assertThat(worker.getSalaryInt(), is(intType));
    }


    @Test
    public void whenReportOnlyTwoDirectoriesSalaryDescription() {
        MemStoreSort store = new MemStoreSort();
        Employer employer = new Employer("Tim", 5000.0);
        Employer employer2 = new Employer("Dick", 5666.0);
        Employer employer3 = new Employer("Travor", 23440.0);
        Employer employer4 = new Employer("Max", 4444.4);
        List<Employer> list = List.of(employer, employer2, employer3, employer4);
        store.addList(list);
        ReportHR engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder().append(" Name; Salary; ")
                .append(employer3.getName()).append("; ")
                .append(employer3.getSalaryDouble()).append(";")
                .append(employer2.getName()).append("; ")
                .append(employer2.getSalaryDouble()).append(";")
                .append(employer.getName()).append("; ")
                .append(employer.getSalaryDouble()).append(";")
                .append(employer4.getName()).append("; ")
                .append(employer4.getSalaryDouble()).append(";");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
