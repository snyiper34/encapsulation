package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private static final int BASKET_CAPACITY = 5;
    private final Product[] products;
    private int productCount;

    public ProductBasket() {
        this.products = new Product[BASKET_CAPACITY];
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < BASKET_CAPACITY) {
            products[productCount] = product;
            productCount++;
            System.out.println("Добавлен продукт: " + product.getName());
        } else {
            System.out.println("Невозможно добавить продукт - корзина заполнена!");
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < productCount; i++) {
            if (products[i] != null) {
                total += products[i].getPrice();
            }
        }
        return total;
    }

    public void printBasketContents() {
        if (productCount == 0) {
            System.out.println("В корзине пусто");
            return;
        }

        System.out.println("Содержимое корзины:");
        int specialCount = 0;

        for (int i = 0; i < productCount; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.toString());

                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProductByName(String productName) {
        for (int i = 0; i < productCount; i++) {
            if (products[i] != null && products[i].getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < BASKET_CAPACITY; i++) {
            products[i] = null;
        }
        productCount = 0;
        System.out.println("Корзина очищена");
    }
}