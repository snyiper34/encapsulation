package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;

import org.skypro.skyshop.search.exceptions.BestResultNotFound;

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
        SearchEngine searchEngine = new SearchEngine(); // БЕЗ параметра - используем конструктор по умолчанию

        System.out.println("\n4. Добавляем товары в поисковый движок:");
        searchEngine.addItem(laptop);    // метод addItem, а не add
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

        System.out.println("\n6. Демонстрация поиска:");

        // Используем метод findBestMatch вместо printSearchResults
        try {
            System.out.println("\nПоиск 'ноутбук':");
            Searchable result = searchEngine.findBestMatch("ноутбук");
            System.out.println("Найден: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Не найдено: " + e.getMessage());
        }

        try {
            System.out.println("\nПоиск 'беспроводные':");
            Searchable result = searchEngine.findBestMatch("беспроводные");
            System.out.println("Найден: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Не найдено: " + e.getMessage());
        }

        try {
            System.out.println("\nПоиск 'смартфон':");
            Searchable result = searchEngine.findBestMatch("смартфон");
            System.out.println("Найден: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Не найдено: " + e.getMessage());
        }

        try {
            System.out.println("\nПоиск 'кабель':");
            Searchable result = searchEngine.findBestMatch("кабель");
            System.out.println("Найден: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Не найдено: " + e.getMessage());
        }

        try {
            System.out.println("\nПоиск '2024':");
            Searchable result = searchEngine.findBestMatch("2024");
            System.out.println("Найден: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Не найдено: " + e.getMessage());
        }

        try {
            System.out.println("\nПоиск 'планшет' (не существует):");
            Searchable result = searchEngine.findBestMatch("планшет");
            System.out.println("Найден: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Не найдено: " + e.getMessage());
        }

        System.out.println("\n7. Демонстрация работы корзины:");
        ProductBasket basket = new ProductBasket();
        basket.addProduct(laptop);
        basket.addProduct(smartphone);
        basket.addProduct(headphones);
        basket.addProduct(cable);

        basket.printBasketContents();

        System.out.println("\n8. Демонстрация getStringRepresentation():");
        System.out.println(laptop.getStringRepresentation());
        System.out.println(article1.getStringRepresentation());

        System.out.println("\n9. Проверка методов интерфейса Searchable:");
        System.out.println("Ноутбук SearchTerm: " + laptop.getSearchTerm());
        System.out.println("Ноутбук ContentType: " + laptop.getContentType());
        System.out.println("Статья SearchTerm: " + article1.getSearchTerm());
        System.out.println("Статья ContentType: " + article1.getContentType());

        System.out.println("\n10. Добавляем больше товаров для тестирования:");
        SimpleProduct keyboard = new SimpleProduct("Механическая клавиатура", 4500);
        SimpleProduct monitor = new SimpleProduct("Игровой монитор", 25000);
        DiscountedProduct tablet = new DiscountedProduct("Планшет Apple", 45000, 15);
        FixPriceProduct stand = new FixPriceProduct("Подставка для ноутбука");
        SimpleProduct webcam = new SimpleProduct("Веб-камера Full HD", 3000);
        SimpleProduct router = new SimpleProduct("Wi-Fi роутер", 5000);

        searchEngine.addItem(keyboard);
        searchEngine.addItem(monitor);
        searchEngine.addItem(tablet);
        searchEngine.addItem(stand);
        searchEngine.addItem(webcam);
        searchEngine.addItem(router);

        // Создадим еще статью
        Article article5 = new Article(
                "Игровая периферия",
                "Обзор лучших клавиатур, мышей и мониторов для геймеров."
        );
        searchEngine.addItem(article5);

        try {
            System.out.println("\nПоиск 'игр':");
            Searchable result = searchEngine.findBestMatch("игр");
            System.out.println("Найден: " + result.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Не найдено: " + e.getMessage());
        }

        System.out.println("\n=== Демонстрация завершена ===");
    }
}
