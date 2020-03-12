package ru.design.principe;

import java.util.Map;
import java.util.Objects;

public interface Template {
    /*
    I am ${name} ,Who are ${subject}?
     */
    String generate(String template, Map<String, String> stroke);
}
