package ru.job4j.archive;

import ru.job4j.io.PrintFiles;
import ru.job4j.io.Search;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<String> sources, File target) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(target))) {
            for (String path : sources) {
                File file = new File(path);
                zout.putNextEntry(new ZipEntry(file.getPath()));
                FileInputStream in = new FileInputStream(file.getPath());
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

    public static void main(String[] args) throws IOException {
        new Zip().packFiles(Search.search(Path.of("./IO/pom.xml"), "txt"), new File("target.zip"));
    }
}
