package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.repository;

import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model.AccountJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountJpaModel, Long> {

}
