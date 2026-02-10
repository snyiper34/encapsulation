package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.exceptions.BestResultNotFound;
import java.util.List;

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

        System.out.println("\n6. Демонстрация нового метода search() (возвращает List<Searchable>):");

        System.out.println("\nПоиск 'ноутбук':");
        List<Searchable> results = searchEngine.search("ноутбук");
        if (results.isEmpty()) {
            System.out.println("Не найдено");
        } else {
            System.out.println("Найдено " + results.size() + " результатов:");
            for (Searchable result : results) {
                System.out.println("  - " + result.getStringRepresentation());
            }
        }

        System.out.println("\nПоиск 'беспроводные':");
        results = searchEngine.search("беспроводные");
        if (results.isEmpty()) {
            System.out.println("Не найдено");
        } else {
            System.out.println("Найдено " + results.size() + " результатов:");
            for (Searchable result : results) {
                System.out.println("  - " + result.getStringRepresentation());
            }
        }

        System.out.println("\nПоиск 'планшет' (не существует):");
        results = searchEngine.search("планшет");
        if (results.isEmpty()) {
            System.out.println("Не найдено (список пуст)");
        }

        System.out.println("\n7. Демонстрация работы корзины с новым функционалом:");
        ProductBasket basket = new ProductBasket();

        basket.addProduct(laptop);
        basket.addProduct(smartphone);
        basket.addProduct(headphones);
        basket.addProduct(cable);
        basket.addProduct(new SimpleProduct("Ноутбук Lenovo", 75000)); // Дубликат
        basket.addProduct(new FixPriceProduct("Кабель USB-C 2м")); // Дубликат

        System.out.println("\nКорзина после добавления продуктов:");
        basket.printBasketContents();

        System.out.println("\n8. Демонстрация удаления продукта по имени:");

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

        System.out.println("\nКорзина после попытки удаления несуществующего продукта:");
        basket.printBasketContents();

        System.out.println("\nУдаляем продукт 'Кабель USB-C 2м':");
        removed = basket.removeProductsByName("Кабель USB-C 2м");
        if (!removed.isEmpty()) {
            System.out.println("Удалено " + removed.size() + " продукт(ов):");
            for (Product product : removed) {
                System.out.println("  - " + product.getStringRepresentation());
            }
        }

        System.out.println("\nФинальное состояние корзины:");
        basket.printBasketContents();

        System.out.println("\n=== Демонстрация завершена ===");

    }
}