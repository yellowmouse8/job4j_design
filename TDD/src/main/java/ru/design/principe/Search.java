package ru.design.principe;

import javax.print.DocFlavor;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import java.io.File;
import java.security.cert.CertificateParsingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Search {
    public Integer max(List<Integer> value, Comparator<Integer> comparator) {
        int max = value.get(0);
        for (Integer val : value) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    public Integer min(List<Integer> value, Comparator<Integer> comparator) {
        return Collections.min(value, comparator);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 3, 4, 5, 6, 7, 54, 34);
        Search search = new Search();
        System.out.println(search.max(list, Comparator.naturalOrder()));
        System.out.println(search.min(list, Comparator.naturalOrder()));
    }
}
