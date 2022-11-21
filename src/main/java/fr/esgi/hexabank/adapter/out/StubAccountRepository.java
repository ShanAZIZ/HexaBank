package fr.esgi.hexabank.adapter.out;

import fr.esgi.hexabank.application.port.out.AccountRepository;
import fr.esgi.hexabank.domain.Account;
import fr.esgi.hexabank.domain.AccountId;

import java.util.UUID;

public final class StubAccountRepository implements AccountRepository {
    @Override
    public AccountId nextId() {
        return AccountId.of(UUID.randomUUID());
    }

    @Override
    public Account findBy(AccountId accountId) {
        return null;
    }

    @Override
    public void save(Account account) {

    }
}
