package com.example.bank.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;

public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
    @Query(value = "SELECT s.balance from AccountEntity s where s.id = :acId")
    BigDecimal findByBalance (@Param("acId") Integer acId);

    @Transactional
    @Query(value = "UPDATE AccountEntity s SET s.balance = :balance WHERE s.id = :acId")
    @Modifying
    void updateBalance(BigDecimal balance , Integer acId);





}
