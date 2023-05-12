package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model;

import static jakarta.persistence.EnumType.STRING;
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
import jakarta.persistence.Enumerated;
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
    // TODO: 2023/05/12 BaseEntity 작업 후 수정 필요
    private Long id;
    private LocalDate birthDate;
    // String 으로 받을지 아님 domain 그냥 사용할지
    @Enumerated(STRING)
    private Gender gender;

    private String email;

    @Embedded
    private NameJpaModel name;

    @Enumerated(STRING)
    private AccountStatus status;

    @Enumerated(STRING)
    private AccountRole role;

    @Embedded
    private AccountProfileJpaModel profile;

    @Embedded
    private ProviderKeyJpaModel key;

    public static AccountJpaModel from(Account account) {
        // id를 이렇게 넣어주면 실수 할수 있을거 같음
        return new AccountJpaModel(account.getId().id(), account.getBirthDate(),
            account.getGender(), account.getEmail().email(), NameJpaModel.from(account.getName()),
            account.getStatus(), account.getRole(),
            AccountProfileJpaModel.from(account.getProfile()),
            ProviderKeyJpaModel.from(account.getKey()));
    }

    public Account toDomainModel() {
        return Account.withId(
            new AccountId(id),
            birthDate,
            gender,
            new Email(email),
            name.toDomainModel(),
            status,
            role,
            profile.toDomainModel(),
            key.toDomainModel()
        );
    }

}
