package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private double basePrice;
    private double discountPercentage;

    public DiscountedProduct(String name, double basePrice, double discountPercentage) {
        super(name);

        if (basePrice <= 0) {
            throw new IllegalArgumentException(
                    String.format("Базовая цена продукта '%s' должна быть строго больше 0. Получено: %.2f",
                            getName(), basePrice)
            );
        }

        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException(
                    String.format("Процент скидки для продукта '%s' должен быть в диапазоне от 0 до 100 включительно. Получено: %.1f",
                            getName(), discountPercentage)
            );
        }

        this.basePrice = basePrice;
        this.discountPercentage = discountPercentage;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public double getFinalPrice() {
        return basePrice * (1 - discountPercentage / 100);
    }

    @Override
    public double getPrice() {
        return getFinalPrice();
    }

    @Override
    public boolean isSpecial() {
        return discountPercentage > 0;
    }

    @Override
    public String getSearchTerm() {
        return getName() + " " + basePrice + " " + discountPercentage + "%";
    }

    @Override
    public String getContentType() {
        return "Discounted Product";
    }

    @Override
    public String getStringRepresentation() {
        return String.format("%s - %.2f руб. (скидка %.1f%%, итого: %.2f руб.)",
                getName(), basePrice, discountPercentage, getFinalPrice());
    }

}