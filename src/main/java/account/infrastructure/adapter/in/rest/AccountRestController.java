package account.infrastructure.adapter.in.rest;

import account.application.port.in.SignUpAccountUseCase;
import account.domain.model.aggregate.Account;
import account.infrastructure.adapter.in.rest.mapper.AccountRestModelMapper;
import account.infrastructure.adapter.in.rest.model.AccountResponseDto;
import account.infrastructure.adapter.in.rest.model.CreateAccountRequestDto;
import com.studioplayground.azbackend.infrastructure.adapter.in.rest.model.SuccessResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final SignUpAccountUseCase createAccountUseCase;
    private final AccountRestModelMapper accountRestModelMapper;

    @PostMapping("/api/v1/accounts")
    SuccessResponse<AccountResponseDto> create(@Valid CreateAccountRequestDto request) {
        final Account account = createAccountUseCase.create(accountRestModelMapper.toCommand(request));
        return SuccessResponse.of(AccountResponseDto.from(account));
    }
}
