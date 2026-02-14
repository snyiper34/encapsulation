package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;

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

    public double getTotalPrice() {
        double total = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasketContents() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        System.out.println("Содержимое корзины:");
        int specialCount = 0;
        int totalItems = 0;

        for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            String productName = entry.getKey();
            List<Product> productList = entry.getValue();

            for (Product product : productList) {
                System.out.println("  " + product.getStringRepresentation());
                if (product.isSpecial()) {
                    specialCount++;
                }
                totalItems++;
            }
        }

        System.out.println("Всего товаров: " + totalItems);
        System.out.println("Итого: " + getTotalPrice() + " руб.");
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProductByName(String productName) {
        return productsMap.containsKey(productName);
    }

    public void clearBasket() {
        productsMap.clear();
        System.out.println("Корзина очищена");
    }

    public int getProductCount() {
        int count = 0;
        for (List<Product> productList : productsMap.values()) {
            count += productList.size();
        }
        return count;
    }
}