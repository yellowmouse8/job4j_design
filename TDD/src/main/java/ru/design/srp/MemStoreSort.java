package ru.design.srp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStoreSort implements Store {
    private final List<Employer> employers = new ArrayList<>();

    public void addList(List<Employer> em) {
        employers.addAll(em);
    }

    @Override
    public List<Employer> findBy(Predicate<Employer> filter) {
        return employers.stream().filter(filter).sorted(((o1, o2) -> Double.compare(o2.getSalaryDouble(), o1.getSalaryDouble()))).collect(Collectors.toList());
    }
}
