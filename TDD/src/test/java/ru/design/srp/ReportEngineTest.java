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
    public void whenSalaryDescription() {
        MemStoreSort store = new MemStoreSort();
        Employer worker1 = new Employer("Ben", 3400.32);
        Employer worker2 = new Employer("Fill", 3500.4);
        Employer worker3 = new Employer("Ivan", 5440.4);
        Employer worker4 = new Employer("Jim", 5500.4);
        List<Employer> list = List.of(worker1, worker2, worker3, worker4);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        store.add(worker4);
        List<Employer> expect = List.of(worker4, worker3, worker2, worker1);
        assertThat(store.sorter(list), is(expect));
    }
}
