package com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.repository;

import com.studioplayground.azbackend.account.domain.model.aggregate.Account;
import com.studioplayground.azbackend.account.infrastructure.adapter.out.persistence.model.AccountJPAEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJPARepository extends JpaRepository<AccountJPAEntity, Long> {

    @Query("select account "
        + "from AccountJPAEntity account "
        + "where account.email = :email ")
    Optional<Account> findByEmail(@Param("email") String email);
}
