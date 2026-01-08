package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        Product product1 = new Product("Ноутбук", 50000);
        Product product2 = new Product("Телефон", 30000);
        Product product3 = new Product("Наушники", 5000);
        Product product4 = new Product("Планшет", 40000);
        Product product5 = new Product("Мышь", 1000);
        Product product6 = new Product("Клавиатура", 2000); // Для теста переполнения

        ProductBasket basket = new ProductBasket();

        System.out.println("=== Добавление продуктов ===");
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        System.out.println("\n=== Попытка добавить в заполненную корзину ===");
        basket.addProduct(product6);

        System.out.println("\n=== Содержимое корзины ===");
        basket.printBasketContents();

        System.out.println("\n=== Стоимость корзины ===");
        System.out.println("Стоимость: " + basket.getTotalPrice());

        System.out.println("\n=== Поиск товара 'Телефон' ===");
        System.out.println("Найден: " + basket.containsProductByName("Телефон"));

        System.out.println("\n=== Поиск товара 'Монитор' ===");
        System.out.println("Найден: " + basket.containsProductByName("Монитор"));

        System.out.println("\n=== Очистка корзины ===");
        basket.clearBasket();

        System.out.println("\n=== Содержимое после очистки ===");
        basket.printBasketContents();

        System.out.println("\n=== Стоимость после очистки ===");
        System.out.println("Стоимость: " + basket.getTotalPrice());


        System.out.println("\n=== Поиск в пустой корзине ===");
        System.out.println("Найден 'Ноутбук': " + basket.containsProductByName("Ноутбук"));
    }
}