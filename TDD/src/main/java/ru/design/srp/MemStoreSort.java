package ru.design.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStoreSort extends MemStore {

    public List<Employer> sorter(List<Employer> list) {
        return list.stream()
                .sorted(((o1, o2) -> Double.compare(o2.getSalaryDouble(), o1.getSalaryDouble())))
                .collect(Collectors.toList());
    }
}
