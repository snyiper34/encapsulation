package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

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
        SearchEngine searchEngine = new SearchEngine(20); // Вместимость 20 элементов

        System.out.println("\n4. Добавляем товары в поисковый движок:");
        searchEngine.add(laptop);
        searchEngine.add(mouse);
        searchEngine.add(smartphone);
        searchEngine.add(headphones);
        searchEngine.add(cable);
        searchEngine.add(adapter);

        System.out.println("\n5. Добавляем статьи в поисковый движок:");
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        System.out.println("\n6. Демонстрация поиска:");

        searchEngine.printSearchResults("ноутбук");

        searchEngine.printSearchResults("беспроводные");

        searchEngine.printSearchResults("смартфон");

        searchEngine.printSearchResults("кабель");

        searchEngine.printSearchResults("2024");
        searchEngine.printSearchResults("планшет");

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

        System.out.println("\n10. Тестирование поиска с ограничением 5 результатов:");

        SimpleProduct keyboard = new SimpleProduct("Механическая клавиатура", 4500);
        SimpleProduct monitor = new SimpleProduct("Игровой монитор", 25000);
        DiscountedProduct tablet = new DiscountedProduct("Планшет Apple", 45000, 15);
        FixPriceProduct stand = new FixPriceProduct("Подставка для ноутбука");
        SimpleProduct webcam = new SimpleProduct("Веб-камера Full HD", 3000);
        SimpleProduct router = new SimpleProduct("Wi-Fi роутер", 5000);

        searchEngine.add(keyboard);
        searchEngine.add(monitor);
        searchEngine.add(tablet);
        searchEngine.add(stand);
        searchEngine.add(webcam);
        searchEngine.add(router);

        // Создадим еще статью
        Article article5 = new Article(
                "Игровая периферия",
                "Обзор лучших клавиатур, мышей и мониторов для геймеров."
        );
        searchEngine.add(article5);

        searchEngine.printSearchResults("игр");

        System.out.println("\n=== Демонстрация завершена ===");
    }
}