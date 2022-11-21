package fr.esgi.hexabank.application.port.out;

import fr.esgi.hexabank.domain.Account;
import fr.esgi.hexabank.domain.AccountId;

public interface AccountRepository {

    AccountId nextId();
    Account findBy(AccountId accountId);
    void save(Account account);
}
