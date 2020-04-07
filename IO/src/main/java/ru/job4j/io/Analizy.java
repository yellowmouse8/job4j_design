package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Analizy {

    public void unavailable(String source, String target) {
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(source));
            String str;
            while ((str = br.readLine()) != null) {
                if (str.contains("500") || str.contains("400")) {
                    start.append(str);
                    start.append(System.lineSeparator());
                } else {
                    end.append(str);
                    end.append(System.lineSeparator());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            out.println(start.toString());
            out.println(end.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
