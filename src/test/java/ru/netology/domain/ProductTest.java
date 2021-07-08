package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void shouldUseEquals() {
        Product first = new Product(1, "Java I", 1000);
        Product second = new Product(1, "Java I", 1000);
        assertEquals(first, second);
    }

    @Test
    public void shouldSetId() {
        Product first = new Product(1, "Java I", 1000);
        int expected = 2;
        first.setId(expected);
        int actual = first.getId();
        assertEquals(actual, expected);
    }

    @Test
    public void shouldSetPrice() {
        Product first = new Product(1, "Java I", 1000);
        int expected = 2000;
        first.setPrice(expected);
        int actual = first.getPrice();
        assertEquals(actual, expected);
    }

    @Test
    public void shouldSetName() {
        Product first = new Product(1, "Java I", 1000);
        String expected = "Java II";
        first.setName(expected);
        String actual = first.getName();
        assertEquals(actual, expected);
    }

    @Test
    public void shouldEquals() {
        Product first = new Product(1, "Java I", 1000);
        Product second = new Product(1, "Java I", 1000);
        Product third = first;
        assertEquals(first, second);
        assertEquals(first, third);
    }

    @Test
    public void shouldNotEqualsId() {
        Product first = new Product(1, "Java I", 1000);
        Product second = new Product(2, "Java I", 1000);
        assertNotEquals(first, second);
    }

    @Test
    public void shouldNotEqualsName() {
        Product first = new Product(1, "Java I", 1000);
        Product second = new Product(1, "Java II", 1000);
        assertNotEquals(first, second);
    }

    @Test
    public void shouldNotEqualsPrice() {
        Product first = new Product(1, "Java I", 1000);
        Product second = new Product(1, "Java I", 2000);
        assertNotEquals(first, second);
    }

    @Test
    public void shouldNotEqualsClass() {
        Smartphone smartphone = new Smartphone(201, "Smartphone1", 1000, "Samsung");
        Book book = new Book(1, "Java I", 1000, "");
        assertNotEquals(smartphone, book);
    }
    @Test
    public void shouldNotEqualsNull() {
        Product product = new Product();
        Product nullProduct = null;
        assertNotEquals(product, nullProduct);
    }
}
