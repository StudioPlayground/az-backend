package account.application.service;


import account.application.port.in.SignUpAccountUseCase;
import account.application.port.out.CreateAccountPort;
import account.domain.model.aggregate.Account;
import account.domain.model.commands.CreateAccountCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateDeleteAccountService implements SignUpAccountUseCase {

    private final CreateAccountPort createAccountPort;

    @Override
    public Account create(CreateAccountCommand command) {
        return createAccountPort.create(command.toDomainModel());
    }
}
