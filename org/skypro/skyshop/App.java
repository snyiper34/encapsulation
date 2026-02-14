package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.exceptions.BestResultNotFound;
import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация работы интернет-магазина с поиском ===\n");

        System.out.println("1. Создаем продукты:");
        SimpleProduct laptop = new SimpleProduct("Ноутбук Lenovo", 75000);
        SimpleProduct mouse = new SimpleProduct("Беспроводная мышь", 1500);
        DiscountedProduct smartphone = new DiscountedProduct("Смартфон Samsung", 35000, 10);
        DiscountedProduct headphones = new DiscountedProduct("Беспроводные наушники", 8000, 20);
        FixPriceProduct cable = new FixPriceProduct("Кабель USB-C 2м");
        FixPriceProduct adapter = new FixPriceProduct("Адаптер питания 65W");

        System.out.println("\n2. Создаем статьи:");
        Article article1 = new Article(
                "Как выбрать ноутбук",
                "В этом руководстве мы расскажем, на что обратить внимание при выборе ноутбука для работы и учебы."
        );

        Article article2 = new Article(
                "Преимущества беспроводных наушников",
                "Беспроводные наушники обеспечивают свободу движения и высокое качество звука."
        );

        Article article3 = new Article(
                "Обзор смартфонов 2024",
                "Лучшие смартфоны этого года: сравнение характеристик и цен."
        );

        Article article4 = new Article(
                "Советы по уходу за техникой",
                "Как продлить срок службы вашей электроники: простые правила."
        );

        System.out.println("\n3. Создаем поисковый движок:");
        SearchEngine searchEngine = new SearchEngine();

        System.out.println("\n4. Добавляем товары в поисковый движок:");
        searchEngine.addItem(laptop);
        searchEngine.addItem(mouse);
        searchEngine.addItem(smartphone);
        searchEngine.addItem(headphones);
        searchEngine.addItem(cable);
        searchEngine.addItem(adapter);

        System.out.println("\n5. Добавляем статьи в поисковый движок:");
        searchEngine.addItem(article1);
        searchEngine.addItem(article2);
        searchEngine.addItem(article3);
        searchEngine.addItem(article4);

        System.out.println("\n6. Демонстрация поиска с алфавитным порядком:");

        searchEngine.addItem(new SimpleProduct("Apple MacBook", 120000));
        searchEngine.addItem(new SimpleProduct("Asus ZenBook", 85000));
        searchEngine.addItem(new Article("Z-Phones Review", "Обзор самых дорогих наушников"));

        System.out.println("\nПоиск 'ноутбук' (результаты в алфавитном порядке):");
        Map<String, Searchable> resultsMap = searchEngine.search("ноутбук");
        if (resultsMap.isEmpty()) {
            System.out.println("Не найдено");
        } else {
            System.out.println("Найдено " + resultsMap.size() + " результатов:");
            for (Searchable result : resultsMap.values()) {
                System.out.println("  - " + result.getStringRepresentation());
            }
        }

        System.out.println("\nПоиск 'беспроводные' (результаты в алфавитном порядке):");
        resultsMap = searchEngine.search("беспроводные");
        if (resultsMap.isEmpty()) {
            System.out.println("Не найдено");
        } else {
            System.out.println("Найдено " + resultsMap.size() + " результатов:");
            for (Searchable result : resultsMap.values()) {
                System.out.println("  - " + result.getStringRepresentation());
            }
        }

        System.out.println("\n7. Демонстрация работы корзины с HashMap и computeIfAbsent:");
        ProductBasket basket = new ProductBasket();

        basket.addProduct(laptop);
        basket.addProduct(smartphone);
        basket.addProduct(headphones);
        basket.addProduct(cable);
        basket.addProduct(new SimpleProduct("Ноутбук Lenovo", 75000)); // Дубликат
        basket.addProduct(new FixPriceProduct("Кабель USB-C 2м")); // Дубликат
        basket.addProduct(new SimpleProduct("Apple iPad", 40000)); // Новый продукт

        System.out.println("\nКорзина после добавления продуктов:");
        basket.printBasketContents();

        System.out.println("\n8. Демонстрация удаления продукта по имени (remove по ключу):");

        System.out.println("Удаляем продукт 'Ноутбук Lenovo':");
        List<Product> removed = basket.removeProductsByName("Ноутбук Lenovo");
        if (removed.isEmpty()) {
            System.out.println("Продукт не найден в корзине");
        } else {
            System.out.println("Удалено " + removed.size() + " продукт(ов):");
            for (Product product : removed) {
                System.out.println("  - " + product.getStringRepresentation());
            }
        }

        System.out.println("\nКорзина после удаления:");
        basket.printBasketContents();

        System.out.println("\nУдаляем продукт 'Планшет' (не существует):");
        removed = basket.removeProductsByName("Планшет");
        if (removed.isEmpty()) {
            System.out.println("Список удаленных продуктов пустой - продукт не найден");
        }

        System.out.println("\n=== Демонстрация завершена ===");
    }
}