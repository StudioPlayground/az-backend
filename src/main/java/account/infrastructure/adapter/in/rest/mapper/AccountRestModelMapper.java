package account.infrastructure.adapter.in.rest.mapper;

import account.domain.model.commands.CreateAccountCommand;
import account.infrastructure.adapter.in.rest.model.CreateAccountRequestDto;
import org.mapstruct.Mapper;

@Mapper
public interface AccountRestModelMapper {
    CreateAccountCommand toCommand(CreateAccountRequestDto createAccountRequestDto);
}
