package fr.esgi.hexabank.domain;

import java.util.UUID;

public class Account {

    private final UUID id;
    private final Money balance;

    public Account(UUID id, Money balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(Money money){}

    public void withdraw(Money money){}
}
