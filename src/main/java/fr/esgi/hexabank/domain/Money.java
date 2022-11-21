package fr.esgi.hexabank.domain;

import java.math.BigDecimal;

public class Money {

    private BigDecimal value;

    public Money(BigDecimal value) {
        this.value = value;
    }

    public double getDoubleValue() {
        return value.doubleValue();
    }

    public static Money of(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money add(Money money) {
        return new Money(value.subtract(money.value));
    }

    public Money minus(Money money) {
        return new Money(value.add(money.value));
    }
}
