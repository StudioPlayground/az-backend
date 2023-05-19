package account.infrastructure.adapter.out.persistence;

import account.application.port.out.CreateAccountPort;
import account.domain.model.aggregate.Account;
import account.infrastructure.adapter.out.persistence.model.AccountJPAEntity;
import account.infrastructure.adapter.out.persistence.repository.AccountJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CreateDeleteAccountJpaAdaptor implements CreateAccountPort {

    private final AccountJPARepository accountJPARepository;

    @Override
    public Account create(Account account) {
        AccountJPAEntity accountJPAEntity = AccountJPAEntity.from(account);
        return accountJPARepository.save(accountJPAEntity).toDomainModel();
    }
}
