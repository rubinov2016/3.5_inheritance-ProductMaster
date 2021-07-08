package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    public void shouldSetAuthor() {
        Book first = new Book(1, "Java I", 1000, "author1");
        String expected = "author2";
        first.setAuthor(expected);
        String actual = first.getAuthor();
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
    public void shouldNotEqualsDifferentClass() {
        Book book = new Book(1, "Java I", 1000, "author1");
        Smartphone smartphone = new Smartphone(201, "Smartphone1", 1000, "Samsung");
        assertNotEquals(book, smartphone);
    }

    @Test
    public void shouldEquals() {
        Book firstBook = new Book(1, "Java I", 1000, "author1");
        Book secondBook = new Book(1, "Java I", 1000, "author1");
        assertEquals(firstBook, secondBook);
    }

    @Test
    public void shouldNotEqualsClass() {
        Smartphone smartphone = new Smartphone(201, "Smartphone1", 1000, "Samsung");
        Book book = new Book(1, "Java I", 1000, "");
        assertNotEquals(smartphone, book);
    }
    @Test
    public void shouldNotEqualsNull() {
        Book book = new Book();
        Book nullBook = null;
        assertNotEquals(book, nullBook);
    }
    @Test
    public void shouldNotEqualsPrice() {
        Book first = new Book(1, "Java I", 1000, "author1");
        Book second = new Book(1, "Java I", 2000, "author1");
        assertNotEquals(first, second);
    }
    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book firstEmptyBook = new Book();
        Book secondEmptyBook = new Book();
        assertEquals(firstEmptyBook, secondEmptyBook);

    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Book();
        if (product instanceof Book) {
            Book book = (Book) product;
//      book.
        }
    }

//  @Test
//  public void shouldNotCastToDifferentClass() {
//    Product product = new Book();
//    TShirt shirt = (TShirt) product;
//  }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Book();
        // Вопрос к аудитории: чей метод вызовется?
        product.toString();
    }
}
