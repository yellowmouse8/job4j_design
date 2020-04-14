package ru.job4j.archive;

import ru.job4j.io.Search;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<File> sources, File target) {
        try {
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(target));
            for (File file : sources) {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
                zout.putNextEntry(new ZipEntry(file.getPath()));
                byte[] buffer = new byte[in.available()];
                in.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            FileInputStream in = new FileInputStream(source.getPath());
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            zip.write(buffer);
            zip.closeEntry();

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Zip().packSingleFile(
                new File("input.txt")
                , new File("./IO/input.zip")
        );

        List<File> list = new ArrayList<>();
        File file = new File("/IO/");
        list.add(file);
        new Zip().packFiles(list, new File("target.zip"));
    }
}
