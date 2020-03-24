package ru.design.srp;

import java.awt.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ReportHR {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employer> filter) {
        StringBuilder text = new StringBuilder();
        text.append(" Name; Salary; ");
        for (Employer employer : store.findBy(filter)) {
            text.append(employer.getName()).append("; ")
                    .append(employer.getSalaryDouble()).append(";");
        }
        return text.toString();
    }
}
