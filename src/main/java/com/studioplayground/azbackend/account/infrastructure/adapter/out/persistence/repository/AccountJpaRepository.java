package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.repository;

import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model.AccountJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<Long, AccountJpaEntity> {
}
