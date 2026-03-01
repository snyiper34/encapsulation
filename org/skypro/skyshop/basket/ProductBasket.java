package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap;

    public ProductBasket() {
        this.productsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        String productName = product.getName();

        List<Product> productList = productsMap.computeIfAbsent(productName, k -> new ArrayList<>());
        productList.add(product);

        System.out.println("Добавлен продукт: " + productName);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = productsMap.remove(name);

        if (removedProducts == null) {
            return new ArrayList<>();
        }

        return removedProducts;
    }

    public int getTotalPrice() {
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    private long getSpecialCount() {
        return productsMap.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void printBasketContents() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        System.out.println("Содержимое корзины:");

        productsMap.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> System.out.println("  " + product.getStringRepresentation()));

        long specialCount = getSpecialCount();
        int totalPrice = getTotalPrice();

        long totalItems = productsMap.values().stream()
                .mapToLong(List::size)
                .sum();

        System.out.println("Всего товаров: " + totalItems);
        System.out.println("Итого: " + totalPrice + " руб.");
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProductByName(String productName) {
        return productsMap.containsKey(productName);
    }

    public void clearBasket() {
        productsMap.clear();
        System.out.println("Корзина очищена");
    }
}