package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void errorsFind() {
        Product product = new Product(10, "Мячей", 120);

        int expected = 10;
        int actual = product.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveExistingElement() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 150);
        Product product2 = new Product(2, "Product 2", 200);
        repository.add(product1);
        repository.add(product2);

        repository.remove(1);
        Product[] products = repository.findAll();

        Assertions.assertEquals(1, products.length);
        Assertions.assertEquals(product2, products[0]);
    }

    @Test
    public void testRemoveNonExistingElement() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        repository.add(product1);

        Assertions.assertThrows(NotFoundException.class, () -> repository.remove(2));
    }
}