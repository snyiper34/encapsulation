package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final double FIXED_PRICE = 5000.0;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getSearchTerm() {
        return getName() + " фиксированная цена " + FIXED_PRICE;
    }

    @Override
    public String getContentType() {
        return "FixPriceProduct";
    }

    @Override
    public String getStringRepresentation() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE + " руб.";
    }

}