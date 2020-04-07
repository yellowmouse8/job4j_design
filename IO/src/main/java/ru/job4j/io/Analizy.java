package ru.job4j.io;

import java.io.*;
import java.util.*;


public class Analizy {
    List<String> list = new ArrayList<>();

    public void unavailable(String source, String target) {
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(source));
            /*
            Настройка диапазона , с помощью Булева значения.
             */
            boolean test = true;
            String str;
            while ((str = br.readLine()) != null) {
                if (!str.isEmpty()) {
                    if (str.contains("500") || str.contains("400")) {
                        /*
                        Если значение true , то производится запись в  с диапазоном до false;
                         */
                        if (test) {
                                /*
                              Записывает значение начиная с 4 элемента , то есть без (400, 500 или 200);
                                 */
                            start.append(str.substring(4));
                            test = false;
                        }
                    } else {
                        if (!test) {
                            end.append(str.substring(4));
                            test = true;
                        }
                    }

                /*
                Записывает готовые результаты в коллекцию.
                Если остаются пустые строки со знаком "<->" , или время без диапазона, то очищает и оставляет
                только дипазоны с нерабочим временем.

                 */
                    if (start.length() != 0 && end.length() != 0) {
                        list.add(String.join(" <-> ", start, end));
                        start.setLength(0);
                        end.setLength(0);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try /*
            Создает новый преобразованный файл  и заносит в него диапазоны из коллекции;
             */
                (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {

            for (String s : list) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
