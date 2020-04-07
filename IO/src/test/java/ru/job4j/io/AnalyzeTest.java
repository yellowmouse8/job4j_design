package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalyzeTest {
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
}
