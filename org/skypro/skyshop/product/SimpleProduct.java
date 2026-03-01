package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private double price;

    public SimpleProduct(String name, double price) {
        super(name);

        if (price <= 0) {
            throw new IllegalArgumentException(
                    String.format("Цена продукта '%s' должна быть строго больше 0. Получено: %.2f",
                            getName(), price)
            );
        }

        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getSearchTerm() {
        String priceStr = (price == (int) price)
                ? String.valueOf((int) price)
                : String.valueOf(price);
        return getName() + " " + priceStr;
    }

    @Override
    public String getContentType() {
        return "Simple Product";
    }

    @Override
    public String getStringRepresentation() {
        return String.format("%s - %.2f руб.", getName(), price);
    }

}