package javalang.java9.features;

public interface PricedObject {

    double getPrice();

    default double getPriceWithTax() {
        return getPriceWithTaxInternal();
    }

    default double getPriceWithDiscount() {
        return getPriceWithTaxInternal() * 0.80;
    }

    private double getPriceWithTaxInternal() {
        return getPrice() * 1.20;
    }
}
