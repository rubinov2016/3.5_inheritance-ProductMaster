package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartphoneTest {
    @Test
    public void shouldSetProducer() {
        Smartphone first = new Smartphone(1, "Java I", 1000, "producer1");
        String expected = "producer2";
        first.setProducer(expected);
        String actual = first.getProducer();
        assertEquals(actual, expected);
    }

    @Test
    public void shouldSetTitle() {
        Book first = new Book(1, "Java I", 1000, "author1");
        String expected = "title2";
        first.setTitle(expected);
        String actual = first.getTitle();
        assertEquals(actual, expected);
    }

    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Smartphone firstEmptySmartphone = new Smartphone();
        Smartphone secondEmptySmartphone = new Smartphone();
        assertEquals(firstEmptySmartphone, secondEmptySmartphone);
    }
}
