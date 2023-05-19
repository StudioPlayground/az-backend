package account.application.port.out;

import account.domain.model.aggregate.Account;

public interface CreateAccountPort {
    Account create(Account account);
}
