package ru.design.principe;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator implements Template {
    private final String STROKE = "^\\$\\W+[A-Za-z]+\\W+$";
    private final Pattern PATTERN = Pattern.compile(STROKE);

    @Override
    public String generate(String template, Map<String, String> stroke) {
        Matcher m = PATTERN.matcher(template);
        StringBuffer sb = new StringBuffer();
        while (m.find()){
            if (stroke.containsKey(m.group(1))){
                m.appendReplacement(sb, stroke.get(m.group(1)));
            } else {
                m.appendReplacement(sb, m.group(0));
            }
        }
        m.appendTail(sb);
        return sb.toString();
    }
}