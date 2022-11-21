package fr.esgi.hexabank.adapter.in;

import fr.esgi.hexabank.application.services.AccountService;
import fr.esgi.hexabank.domain.AccountId;
import fr.esgi.hexabank.domain.Money;

public final class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void create(Money initialAmount){
        accountService.createAccount(initialAmount);
    }

    public void transfer(AccountId source, AccountId target, Money amount){
        accountService.sendMoney(source, target, amount);
    }

}
