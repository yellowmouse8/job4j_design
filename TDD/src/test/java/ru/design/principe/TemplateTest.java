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
        String text = "I am ${name}, who are ${subject}?";
        Map<String, String> data = Map.of("${name}", "Pi", "${subject}", "you");
        String checked = "I am Pi, who are you?";
        //act
        String result = template.generate(text, data);
        //action
        Assert.assertThat(result, is(checked));

    }

    @Test
    public void whenAllSubjectsDone() {
        Template template = new SimpleGenerator();
        String text = "${name} , ${sos} , ${sos} , ${sos} !";
        Map<String, String> data = Map.of("${name}", "Help", "${sos}", "Aaaa");
        String checked = "Help , Aaaa , Aaaa , Aaaa !";
        String result = template.generate(text, data);
        Assert.assertThat(result, is(checked));
    }

    @Test(expected = IllegalStateException.class)
    public void whenAllSubjectsIncorrect() {
        Template template = new SimpleGenerator();
        String text = "${name} , ${sos} , ${sos} , ${sos} !";
        Map<String, String> data = Map.of("${name}", "Help", "${sss}", "Aaaa");
        String result = template.generate(text, data);
        System.out.println(result);
    }

    @Test (expected =  IllegalArgumentException.class)
    public void whenTooMuchKeys() {
        Template template = new SimpleGenerator();
        String text = "${name} , ${sos} , ${sos} , ${sos} !";
        Map<String, String> data = Map.of("${name}", "Help", "${sos}", "Aaaa", "${sos}", "Aaaa");
        String result = template.generate(text, data);
        System.out.println(result);
    }
}
