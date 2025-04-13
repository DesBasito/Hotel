package service;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PaymentService {
    private static final int TAX = 5;

    public double applyTax(double amount) {
        return amount + (amount * TAX / 100);
    }

    public double applyDiscount(double amount, double discountRate) {
        return amount + (amount * discountRate / 100);
    }
}
