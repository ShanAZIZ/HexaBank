package fr.esgi.hexabank.domain;

public class Account {

    private final AccountId id;
    private Money balance;

    public Account(AccountId id, Money balance) {
        this.id = id;
        this.balance = balance;
    }

    public AccountId id(){
        return id;
    }

    public void deposit(Money money){
        validateTransfert(money);
        this.balance = this.balance.add(money);
    }

    public void withdraw(Money money){
        validateTransfert(money);
        this.balance = this.balance.minus(money);
    }

    private void validateTransfert(Money money){
        if(money.getDoubleValue() <= 0){
            throw new RuntimeException();
        }
    }
}
