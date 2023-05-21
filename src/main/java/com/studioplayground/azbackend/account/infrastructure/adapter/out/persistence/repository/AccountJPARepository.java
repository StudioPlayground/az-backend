package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.repository;

import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model.AccountJPAEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJPARepository extends JpaRepository<AccountJPAEntity, Long> {}
