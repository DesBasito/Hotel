package service;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.math.RoundingMode;

@UtilityClass
public class PaymentService {
    private static final int TAX = 5;

    public double applyTax(double amount) {
        return BigDecimal
                .valueOf(amount + (amount * TAX / 100))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public double applyDiscount(double amount, double discountRate) {
        return  BigDecimal
                .valueOf(amount - (amount * discountRate / 100))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
