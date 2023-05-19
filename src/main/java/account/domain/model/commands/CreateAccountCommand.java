package account.domain.model.commands;

import account.domain.model.aggregate.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
public class CreateAccountCommand {

    private LocalDate birthDate;
    private String gender;

    private String email;

    private String name;

    private String profileNickName;
    private String url;
    private String status;
    private String role;

    public Account toDomainModel() {
        return Account.withOutId(birthDate, Gender.from(gender), Email.from(email), name,
                AccountStatus.from(status), AccountRole.from(role), AccountProfile.from(profileNickName, url));
    }
}



