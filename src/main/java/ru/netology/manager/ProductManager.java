package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }
//для каждого продукта вызывать определённый в классе менеджера же метод matches,
// который проверяет, соответствует ли продукт поисковому запросу.

    public Product[] searchBy(String text) {
        Product[] items = findAll();
        Product[] foundItems = new Product[0];
        //ProductManager foundItems = new ProductManager(repository);
        for (Product item : items) {
            if (matches(item, text)) {
                int length = foundItems.length + 1;
                Product[] tmp = new Product[length];
                System.arraycopy(foundItems, 0, tmp, 0, foundItems.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = item;
                foundItems = tmp;
            }
        }
        return foundItems;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (book.getTitle().contains(search)) {
                return true;
            }
            return false;
        } else if (product instanceof Smartphone) { // если в параметре product лежит объект класса Smartphone
            Smartphone smartphone = (Smartphone) product; // положем его в переменную типа Smartphone чтобы пользоваться методами класса Book
            if (smartphone.getProducer().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] findAll() {
        Product[] products = repository.findAll();
        return products;
    }

    public Product findById(int id) {
        Product product = repository.findById(id);
        return product;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }


}
