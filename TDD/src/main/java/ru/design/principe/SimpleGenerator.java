package ru.design.principe;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator implements Template {

    @Override
    public String generate(String template, Map<String, String> stroke) {
        return stroke.keySet().stream().reduce(template, (value, key) -> value
                .replaceAll("\\$\\{" + key + "\\W", stroke.get(key)));

    }
}