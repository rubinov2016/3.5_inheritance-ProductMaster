package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    private Book bookFirst = new Book(101, "Book name1", 1000, "author1");

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.save(coreJava);
        repository.save(bookFirst);
        repository.removeById(bookFirst.getId());
        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        repository.save(coreJava);
        repository.save(bookFirst);
        Product[] expected = new Product[]{bookFirst};
        int foundId = bookFirst.getId();
        Product[] actual = new Product[]{repository.findById(foundId)};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdNull() {
        //repository.save(coreJava);
        Product[] actual = {repository.findById(0)};
        Product[] expected = {null};
        assertArrayEquals(expected, actual);
    }
}
