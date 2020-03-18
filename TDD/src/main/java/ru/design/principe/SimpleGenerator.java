package ru.design.principe;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator implements Template {
    private final String STROKE = "\\$\\{[A-Za-z]+\\W";
    private final Pattern PATTERN = Pattern.compile(STROKE);
    private Matcher m;

    @Override
    public String generate(String template, Map<String, String> stroke) {
        m = PATTERN.matcher(template);
        StringBuffer sb = new StringBuffer();
        Set<String> set = new HashSet<>(stroke.keySet());

        while (m.find()) {
            if (!stroke.containsKey(m.group())) {
                throw new IllegalStateException("Не соответствие шаблону ! ");
            }
            m.appendReplacement(sb, stroke.get(m.group()));
        }
        if (stroke.keySet().size() > set.size()) {
            throw new IllegalArgumentException("Doubles has here. ");
        }
        m.appendTail(sb);
        return sb.toString();
    }
}
