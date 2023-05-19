package account.application.port.in;

import account.domain.model.aggregate.Account;
import account.domain.model.commands.CreateAccountCommand;

public interface SignUpAccountUseCase {
    Account create(CreateAccountCommand createAccountCommand);
}
