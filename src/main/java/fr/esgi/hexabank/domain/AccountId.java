package fr.esgi.hexabank.domain;

import java.util.Objects;
import java.util.UUID;

public class AccountId {

    private UUID value;

    public AccountId(UUID value) {
        this.value = value;
    }

    public static AccountId of(UUID value) {
        return new AccountId(value);
    }

    public String value() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountId accountId = (AccountId) o;
        return Objects.equals(value, accountId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "AccountId{" +
                "value=" + value +
                '}';
    }
}
