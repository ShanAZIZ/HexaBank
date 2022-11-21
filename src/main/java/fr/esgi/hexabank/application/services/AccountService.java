package fr.esgi.hexabank.application.services;

import fr.esgi.hexabank.application.port.out.AccountRepository;
import fr.esgi.hexabank.domain.Account;
import fr.esgi.hexabank.domain.AccountConfiguration;
import fr.esgi.hexabank.domain.AccountId;
import fr.esgi.hexabank.domain.Money;
public final class AccountService {
    private final AccountConfiguration accountConfiguration;
    private final AccountRepository accountRepository;

    public AccountService(AccountConfiguration accountConfiguration, AccountRepository accountRepository) {
        this.accountConfiguration = accountConfiguration;
        this.accountRepository = accountRepository;
    }

    public void createAccount(Money initialMoney){
        AccountId accountId = accountRepository.nextId();
        Account account = new Account(accountId, initialMoney);
        accountRepository.save(account);
    }

    public void sendMoney(AccountId sourceAccountId, AccountId targetAccountId, Money amount){
        if(mayNotTransfert(amount)){
            throw new RuntimeException();
        }
        final Account sourceAccount = accountRepository.findBy(sourceAccountId);
        final Account targetAccount = accountRepository.findBy(targetAccountId);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }

    private boolean mayNotTransfert(Money amount){
        return accountConfiguration.tranfertThreshold() < amount.getDoubleValue();
    }
}
