package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model;


import com.studioplayground.azbackend.account.domain.model.AccountRole;
import com.studioplayground.azbackend.account.domain.model.AccountStatus;
import com.studioplayground.azbackend.account.domain.model.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class AccountJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate birthDate;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private AccountStatus status;
    @Enumerated(value = EnumType.STRING)
    private AccountRole role;
}
