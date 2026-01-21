package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация работы интернет-магазина с новыми типами товаров ===\n");

        System.out.println("1. Создаем продукты разных типов:");

        SimpleProduct laptop = new SimpleProduct("Ноутбук", 75000);
        SimpleProduct mouse = new SimpleProduct("Мышь", 1500);

        DiscountedProduct smartphone = new DiscountedProduct("Смартфон", 35000, 10); // 10% скидка
        DiscountedProduct headphones = new DiscountedProduct("Наушники", 8000, 20);   // 20% скидка

        FixPriceProduct cable = new FixPriceProduct("Кабель USB-C");
        FixPriceProduct adapter = new FixPriceProduct("Адаптер питания");

        System.out.println("Создан обычный товар: " + laptop.getName());
        System.out.println("Создан товар со скидкой: " + smartphone.getName() + " (скидка " + smartphone.getDiscountPercent() + "%)");
        System.out.println("Создан товар с фиксированной ценой: " + cable.getName());

        System.out.println("\n2. Создаем корзину:");
        ProductBasket basket = new ProductBasket();

        System.out.println("\n3. Добавляем продукты разных типов в корзину:");
        basket.addProduct(laptop);
        basket.addProduct(smartphone);
        basket.addProduct(headphones);
        basket.addProduct(cable);
        basket.addProduct(adapter);

        System.out.println("\n4. Попытка добавить продукт в заполненную корзину:");
        basket.addProduct(mouse);

        System.out.println("\n5. Печать содержимого корзины (новый формат):");
        basket.printBasketContents();

        System.out.println("\n6. Получение общей стоимости корзины:");
        System.out.println("Общая стоимость: " + basket.getTotalPrice() + " руб.");

        System.out.println("\n7. Поиск товара, который есть в корзине:");
        String searchProduct1 = "Смартфон";
        boolean found1 = basket.containsProductByName(searchProduct1);
        System.out.println("Товар '" + searchProduct1 + "' в корзине: " + found1);

        System.out.println("\n8. Поиск товара, которого нет в корзине:");
        String searchProduct2 = "Планшет";
        boolean found2 = basket.containsProductByName(searchProduct2);
        System.out.println("Товар '" + searchProduct2 + "' в корзине: " + found2);

        System.out.println("\n9. Проверка, какие товары являются специальными:");
        System.out.println("Ноутбук (SimpleProduct) специальный: " + laptop.isSpecial());
        System.out.println("Смартфон (DiscountedProduct) специальный: " + smartphone.isSpecial());
        System.out.println("Кабель (FixPriceProduct) специальный: " + cable.isSpecial());

        System.out.println("\n10. Очистка корзины:");
        basket.clearBasket();


        System.out.println("\n11. Печать содержимого пустой корзины:");
        basket.printBasketContents();

        System.out.println("\n12. Дополнительная демонстрация с разными комбинациями:");
        ProductBasket basket2 = new ProductBasket();

        basket2.addProduct(new SimpleProduct("Книга", 500));
        basket2.addProduct(new DiscountedProduct("Игра", 2000, 25));
        basket2.addProduct(new FixPriceProduct("Стикер"));

        basket2.printBasketContents();

        System.out.println("\n=== Демонстрация завершена ===");
    }
}