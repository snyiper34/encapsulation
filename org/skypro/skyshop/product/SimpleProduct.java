package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);

        if (price <= 0) {
            throw new IllegalArgumentException(
                    String.format("Цена продукта '%s' должна быть строго больше 0. Получено: %d",
                            getName(), price)
            );
        }

        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getSearchTerm() {
        return getName() + " " + price;
    }

    @Override
    public String getContentType() {
        return "Simple Product";
    }

    @Override
    public String getStringRepresentation() {
        return String.format("%s - %d руб.", getName(), price); // %d вместо %.2f
    }
}