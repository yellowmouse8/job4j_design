package ru.job4j.io;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        System.out.println(search(start, "txt"));
    }

    public static List<String> search(Path root, String ext) throws IOException {
        List<String> list = new ArrayList<>();
        try
                (DirectoryStream<Path> stream = Files.newDirectoryStream(root)) {

            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    if (path.getFileName().toString().endsWith(ext)) {
                        list.add(path.getFileName().toString());
                    }
                }
            }
        }
        return list;
    }
}
