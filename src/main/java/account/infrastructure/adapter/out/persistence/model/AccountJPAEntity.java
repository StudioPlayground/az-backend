package account.infrastructure.adapter.out.persistence.model;

import account.domain.model.aggregate.*;
import com.studioplayground.azbackend.common.infrastructure.adapter.out.persistence.model.BaseJpaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
@Table(name = "account")
public class AccountJPAEntity extends BaseJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate birthDate;
    private String gender;
    private String email;
    private String name;
    private String status;
    private String role;

    @Embedded
    private AccountProfileJpaEntity profile;

    public static AccountJPAEntity from(Account account) {
        return new AccountJPAEntity(
                account.getId().id(),
                account.getBirthDate(),
                account.getGender().name(),
                account.getEmail().email(),
                account.getName(),
                account.getStatus().name(),
                account.getRole().name(),
                AccountProfileJpaEntity.from(account.getProfile()));
    }

    public Account toDomainModel() {
        return Account.withId(
                new AccountId(id),
                birthDate,
                Gender.from(gender),
                Email.from(email),
                name,
                AccountStatus.from(status),
                AccountRole.from(role),
                profile.toDomainModel()
        );
    }
}
