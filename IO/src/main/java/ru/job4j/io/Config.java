package ru.job4j.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringJoiner;
import java.util.stream.Collectors;

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
            Properties properties = new Properties();
            properties.load(in);
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                values.put((String) entry.getKey(), (String) entry.getValue());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        InputStream in = null;
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        do {
            try {
                line = br.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } while ((line != null) && line.indexOf(key) == -1);
        return line;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try
                (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
