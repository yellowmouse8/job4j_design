package ru.design.principe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator implements Template {
    private final String STROKE = "\\$\\{[A-Za-z]+\\W";
    private final Pattern PATTERN = Pattern.compile(STROKE);

    @Override
    public String generate(String template, Map<String, String> stroke) {
        Matcher m = PATTERN.matcher(template);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            if (stroke.containsKey(m.group())) {
                m.appendReplacement(sb, stroke.get(m.group()));
            } else {
                throw new IllegalStateException("Не соответствие шаблону ! ");
            }
        }
        m.appendTail(sb);
        return sb.toString();
    }
}
