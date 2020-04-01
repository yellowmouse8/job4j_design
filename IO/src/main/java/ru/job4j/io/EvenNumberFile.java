package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class EvenNumberFile {
    public static void main(String[] args) {
        try
                (BufferedReader in = new BufferedReader(new FileReader("even.txt"))) {
            String read;
            while ((read = in.readLine()) != null) {
                if (Integer.parseInt(read) % 2 != 0) {
                    System.out.println(read);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
