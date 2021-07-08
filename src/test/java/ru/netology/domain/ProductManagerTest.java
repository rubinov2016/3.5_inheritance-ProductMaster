package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {

    Book bookFirst = new Book(101, "Book name1", 1000, "author1");
    Book bookSecond = new Book(102, "Book name2", 1000, "author2");
    Book bookThird = new Book(103, "Book name3", 1000, "author2"); //duplicate author2

    Smartphone smartphoneFirst = new Smartphone(201, "Smartphone1", 1000, "Samsung");
    Smartphone smartphoneSecond = new Smartphone(202, "Smartphone2", 1000, "Samsung");
    Smartphone SmartphoneThird = new Smartphone(203, "Smartphone3", 1000, "Nokia");

    @Test
    public void shouldFindByID() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(smartphoneFirst);
        manager.add(smartphoneSecond);
        manager.add(SmartphoneThird);

        Product expected = bookFirst;
        Product actual = manager.findById(bookFirst.getId());
        assertEquals(actual, expected);
    }

    @Test
    public void shouldSearchByAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(smartphoneFirst);
        manager.add(smartphoneSecond);
        manager.add(SmartphoneThird);

        Product[] expected = {bookSecond, bookThird};
        Product[] actual = manager.searchBy(bookSecond.getAuthor());
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByTitle() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(smartphoneFirst);
        manager.add(smartphoneSecond);
        manager.add(SmartphoneThird);

        Product[] expected = {bookSecond};
        Product[] actual = manager.searchBy(bookSecond.getTitle());
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(smartphoneFirst);
        manager.add(smartphoneSecond);
        manager.add(SmartphoneThird);

        Product[] expected = {smartphoneSecond};
        Product[] actual = manager.searchBy(smartphoneSecond.getName());
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByProducer() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(smartphoneFirst);
        manager.add(smartphoneSecond);
        manager.add(SmartphoneThird);

        Product[] expected = {smartphoneFirst, smartphoneSecond};
        Product[] actual = manager.searchBy(smartphoneSecond.getProducer());
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByNotFound() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(smartphoneFirst);
        manager.add(smartphoneSecond);
        manager.add(SmartphoneThird);

        Product[] expected = {};
        Product[] actual = manager.searchBy("dummy text");
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByEmptyCard() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Product[] expected = {};
        Product[] actual = manager.searchBy("dummy text");
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByDefaultProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product product = new Product(101, "product name1", 1000);
        manager.add(product);

        Product[] expected = {};
        Product[] actual = manager.searchBy("dummy text");
        assertArrayEquals(actual, expected);

        Product[] expected2 = {product};
        actual = manager.searchBy(product.getName());
        assertArrayEquals(actual, expected2);
    }

    @Test
    public void shouldRemoveId() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(smartphoneFirst);
        manager.add(smartphoneSecond);
        manager.add(SmartphoneThird);

        Product[] expected = {bookSecond, bookThird, smartphoneFirst, smartphoneSecond, SmartphoneThird};
        manager.removeById(bookFirst.getId());
        Product[] actual = manager.findAll();
        assertArrayEquals(actual, expected);
    }
}
