package ru.job4j.io;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.nio.file.Files.*;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, "xml");
    }


    public static List<String> search(Path root, String ext) throws IOException {
        List<String> list = new ArrayList<>();
        List<Path> directories = List.of(root.toAbsolutePath());
        for (Path path : directories) {
            if (path.getFileName().endsWith(ext)) {
                list.add(path.getFileName().toString());
            } else {
                System.out.println(" Files not found! ");
            }
        }
        return list;
    }
}
