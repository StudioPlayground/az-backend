package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence;

import com.studioplayground.azbackend.account.application.port.out.ReadAccountPort;
import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.aggregate.Email;
import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.repository.AccountJPARepository;
import com.studioplayground.azbackend.common.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReadAccountJpaAdaptor implements ReadAccountPort {

    private final AccountJPARepository accountJPARepository;

    @Override
    public Account get(Email email) {
        return accountJPARepository.findByEmail(email.email())
            // TODO: 2023/05/26 어케 해야 할가요 
            .orElseThrow(() -> new ValidationException(null, "없음"));
    }
}
