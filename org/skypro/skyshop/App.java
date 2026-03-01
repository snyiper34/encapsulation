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

        System.out.println("\n3. Создаем поисковый движек:");
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

        searchEngine.addItem(new SimpleProduct("A", 100));
        searchEngine.addItem(new SimpleProduct("BB", 200));
        searchEngine.addItem(new SimpleProduct("CCC", 300));
        searchEngine.addItem(new SimpleProduct("DDDD", 400));
        searchEngine.addItem(new Article("E", "Статья с коротким именем"));
        searchEngine.addItem(new Article("FF", "Статья с именем средней длины"));
        searchEngine.addItem(new Article("GGG", "Еще одна статья"));
        searchEngine.addItem(new Article("Очень длинное название статьи для проверки сортировки", "Контент"));

        System.out.println("\n6. Демонстрация поиска с сортировкой (от длинных к коротким):");

        String query = "а";
        System.out.println("\nПоиск по запросу '" + query + "':");
        Set<Searchable> results = searchEngine.search(query);

        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            System.out.println("Найдено " + results.size() + " результатов (отсортировано по длине имени):");
            for (Searchable result : results) {
                System.out.println("  - [" + result.getName().length() + " симв.] " + result.getStringRepresentation());
            }
        }

        System.out.println("\n7. Демонстрация работы корзины (без изменений):");
        ProductBasket basket = new ProductBasket();

        basket.addProduct(laptop);
        basket.addProduct(smartphone);
        basket.addProduct(headphones);
        basket.addProduct(cable);

        System.out.println("\nКорзина после добавления продуктов:");
        basket.printBasketContents();

        System.out.println("\n8. Проверка equals/hashCode (дубликаты не добавляются):");
        System.out.println("Пытаемся добавить продукт с существующим именем 'Ноутбук Lenovo':");
        searchEngine.addItem(new SimpleProduct("Ноутбук Lenovo", 99999));
        System.out.println("Пытаемся добавить статью с существующим заголовком 'Как выбрать ноутбук':");
        searchEngine.addItem(new Article("Как выбрать ноутбук", "Дубликат"));

        System.out.println("\nПовторный поиск (количество результатов не должно увеличиться):");
        results = searchEngine.search("ноутбук");
        System.out.println("Найдено результатов: " + results.size());

        System.out.println("\n=== Демонстрация завершена ===");
    }
}