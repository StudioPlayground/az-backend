package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.domain.model.aggregate.AccountId;
import com.studioplayground.azbackend.account.domain.model.aggregate.AccountRole;
import com.studioplayground.azbackend.account.domain.model.aggregate.AccountStatus;
import com.studioplayground.azbackend.account.domain.model.aggregate.Email;
import com.studioplayground.azbackend.account.domain.model.aggregate.Gender;
import com.studioplayground.azbackend.common.infrastructure.adapter.out.persistence.model.BaseJpaEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
