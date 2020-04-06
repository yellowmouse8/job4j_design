package ru.job4j.io;

import org.junit.Test;
import org.junit.experimental.theories.PotentialAssignment;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Pavel Shakh"));
    }

    @Test
    public void whenValuesWithSpace() {
        String path = "./data/sata.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("comments"), is("tech services"));
    }

    @Test
    public void whenCommentsWithoutEquals() {
        String path = "./data/sata.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Doors"), is("are closing"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenCommentsDoesntExists() {
        String path = "./data/sata.properties";
        Config config = new Config(path);
        config.load();
        String result = config.value("Devastator");
        System.out.println(result);
    }
    @Test
    public void whenRussianSymbols(){
        String path = "./data/sata.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Привет"), is("как дела?"));
    }
}
