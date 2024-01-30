package ru.netology.stat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "хлеб", 50);
        Product product2 = new Product(2, "молоко", 70);
        Product product3 = new Product(3, "яйца", 100000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "хлеб", 50);
        Product product2 = new Product(2, "молоко", 70);
        Product product3 = new Product(3, "яйца", 100000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () ->
                repo.remove(5));


    }

    @Test
    public void testAddWhenIdAlreadyExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "хлеб", 50);
        Product product2 = new Product(2, "молоко", 70);
        Product product3 = new Product(3, "яйца", 100000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () ->
                repo.add(product2));

    }

    @Test
    public void testAddWhenIdNotExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "хлеб", 50);
        Product product2 = new Product(2, "молоко", 70);
        Product product3 = new Product(3, "яйца", 100000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3};

        Assertions.assertArrayEquals(expected, actual);

    }


}