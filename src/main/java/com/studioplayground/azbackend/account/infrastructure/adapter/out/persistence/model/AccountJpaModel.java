package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import com.studioplayground.azbackend.account.domain.model.Account;
import com.studioplayground.azbackend.account.domain.model.AccountId;
import com.studioplayground.azbackend.account.domain.model.AccountRole;
import com.studioplayground.azbackend.account.domain.model.AccountStatus;
import com.studioplayground.azbackend.account.domain.model.Gender;
import com.studioplayground.azbackend.common.domain.model.Email;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class AccountJpaModel {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private LocalDate birthDate;
    private String gender;

    private String email;

    @Embedded
    private NameJpaModel name;

    private String status;

    private String role;

    @Embedded
    private AccountProfileJpaModel profile;

    @Embedded
    private ProviderKeyJpaModel key;

    public static AccountJpaModel from(Account account) {
        return new AccountJpaModel(
            account.getId().id(),
            account.getBirthDate(),
            account.getGender().name(),
            account.getEmail().email(),
            NameJpaModel.from(account.getName()),
            account.getStatus().name(),
            account.getRole().name(),
            AccountProfileJpaModel.from(account.getProfile()),
            ProviderKeyJpaModel.from(account.getKey()));
    }

    public Account toDomainModel() {
        return Account.withId(
            new AccountId(id),
            birthDate,
            Gender.from(gender),
            new Email(email),
            name.toDomainModel(),
            AccountStatus.from(status),
            AccountRole.from(role),
            profile.toDomainModel(),
            key.toDomainModel()
        );
    }

}
