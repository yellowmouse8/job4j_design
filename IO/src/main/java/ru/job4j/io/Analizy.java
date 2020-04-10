package ru.job4j.io;

import java.io.*;
import java.util.*;


public class Analizy {
    private List<String> list = new ArrayList<>();

    public void unavailable(String source, String target) {
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        try {
            File file = new File(source);
            if (!file.exists()) {
                throw new RuntimeException(" Файл не найден ");
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            boolean test = true;
            String str;
            while ((str = br.readLine()) != null) {
                if (!str.isEmpty()) {
                    if (str.contains("500") || str.contains("400")) {
                        if (test) {
                            start.append(str.substring(4));
                            test = false;
                        }
                    } else {
                        if (!test) {
                            end.append(str.substring(4));
                            test = true;
                        }
                    }
                    if (start.length() != 0 && end.length() != 0) {
                        list.add(String.join(" <-> ", start, end));
                        start.setLength(0);
                        end.setLength(0);
                    }
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileWriter(target))) {
            for (String s : list) {
                out.println(s);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
