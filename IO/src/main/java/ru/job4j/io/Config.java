package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringJoiner;


public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try {
            File file = new File(this.path);
            FileInputStream in = new FileInputStream(file);
            InputStreamReader is = new InputStreamReader(in, StandardCharsets.UTF_8);
            Properties properties = new Properties();
            properties.load(is);
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                values.put((String) entry.getKey(), (String) entry.getValue());
            }

        } catch (RuntimeException | FileNotFoundException fa) {
            System.err.println(" Введите существующий файл на вашем компьютере. ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        String value = null;
        for (Map.Entry<String, String> s : values.entrySet()) {
            if (s.getKey().equals(key)) {
                value = s.getValue();
            }
        }
        if (value == null) {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        }
        return value;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try {
            File file = new File(this.path);
            InputStreamReader in = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            BufferedReader read = new BufferedReader(in);
            read.lines().forEach(out::add);
        } catch (RuntimeException | FileNotFoundException fa) {
            System.err.println(" Введите существующий файл на вашем компьютере. ");
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
