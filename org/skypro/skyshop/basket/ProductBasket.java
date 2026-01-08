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
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public void printBasketContents() {
        if (productCount == 0) {
            System.out.println("в корзине пусто");
            return;
        }

        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i].getName() + ": " + products[i].getPrice());
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean containsProductByName(String productName) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(productName)) {
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
    }
}