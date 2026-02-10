package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
        if (name == null) {
            throw new IllegalArgumentException(
                    "Название продукта не может быть null"
            );
        }

        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Название продукта не может быть пустой строкой или строкой, состоящей только из пробелов. Получено: '" + name + "'"
            );
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract double getPrice();
    public abstract boolean isSpecial();

    @Override
    public abstract String getSearchTerm();

    @Override
    public abstract String getContentType();

    @Override
    public abstract String getStringRepresentation();
}