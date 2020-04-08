package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalyzeTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenStartToEnd() {
        List<String> times = List.of("10:57:01 <-> 10:59:01"
                , "11:01:02 <-> 11:02:02");
        Analizy analizy = new Analizy();
        String source = "./data/server.log";
        String target = "./data/unavailable.csv";
        analizy.unavailable(source, target);
        try
                (BufferedReader br = new BufferedReader(new FileReader(target))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                assertThat(line, is(times.get(i)));
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void whenTemporaryFolder () throws IOException {
        Analizy analizy = new Analizy();
        File source = folder.newFile("trap.log");
        File target = folder.newFile("target.scv");
        try
                (PrintWriter out = new PrintWriter(source)) {
            out.append("200 10:56:01");
            out.append("500 10:57:01");
            out.append("400 10:58:01");
            out.append("200 10:59:01");
            out.append("500 11:01:02");
            out.append("200 11:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(),  target.getAbsolutePath());
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(target))) {
            br.lines().forEach(sb::append);
            assertThat(sb.toString(), is ("asf"));
        }
    }
}
