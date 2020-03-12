package ru.design.principe;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator implements Template {
    private final String STROKE = "^\\$\\{[a-z]+}$";
    private final Pattern PATTERN = Pattern.compile(STROKE);

    @Override
    public String generate(String template, Map<String, String> stroke) {
        Matcher m = PATTERN.matcher(template);
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (m.find()) {
            String group = m.group();
            String replacement;
            if (stroke.containsKey(group)) {
                replacement = stroke.get(group);
            } else {
                i++;
                replacement = "^[a-zA-Z]+\\W+";
                stroke.put(group, replacement);
            }
            m.appendReplacement(sb, replacement);
        }
        m.appendTail(sb);
        return sb.toString();
    }
}