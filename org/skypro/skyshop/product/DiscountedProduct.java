package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountPercentage;

    public DiscountedProduct(String name, int basePrice, int discountPercentage) {
        super(name);

        if (basePrice <= 0) {
            throw new IllegalArgumentException(
                    String.format("Базовая цена продукта '%s' должна быть строго больше 0. Получено: %d",
                            getName(), basePrice)
            );
        }

        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException(
                    String.format("Процент скидки для продукта '%s' должен быть в диапазоне от 0 до 100 включительно. Получено: %d",
                            getName(), discountPercentage)
            );
        }

        this.basePrice = basePrice;
        this.discountPercentage = discountPercentage;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public int getFinalPrice() {
        return basePrice * (100 - discountPercentage) / 100;
    }

    @Override
    public int getPrice() {
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
        return String.format("%s - %d руб. (скидка %d%%, итого: %d руб.)",
                getName(), basePrice, discountPercentage, getFinalPrice());
    }
}