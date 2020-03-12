package ru.design.principe;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class TemplateTest {
    @Test
    public void whenTakeTextWithDataShouldReplaceParamsToData() {
        //assign
        Template template = new SimpleGenerator();
        String text = "I am ${name}, who are ${subject}.";
        Map<String, String> data = Map.of("Pi", "You?");
        String checked = "I am Pi, Who are you?";
        //act
        String result = template.generate(text, data);
        //action
        Assert.assertThat(result, is(checked));

    }
    @Test
    public void whenTakeThreeNames(){
        Template template = new SimpleGenerator();
        String text = "${name}, ${sos}, ${sos}, ${sos}!";
        Map<String , String> data = Map.of("Help", "Aaaa");
        String checked = "Help , Aaaa, Aaaa, Aaaa!";
        String result = template.generate(text, data);
        Assert.assertThat(result, is(checked));

    }

}
