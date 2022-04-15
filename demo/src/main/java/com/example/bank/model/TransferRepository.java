package com.example.bank.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransferRepository extends JpaRepository<TransferEntity, Integer> {

    @Query( value = "SELECT * from accounts_transfer_history  where accounts_from = :accountId or accounts_to = :accountId", nativeQuery = true)
    List<TransferEntity> findAllByAccountsFromAndAccountsToNative(@Param("accountId") Integer accId);

    @Query( value = "SELECT t from TransferEntity t where t.accountsFrom = :accountId or t.accountsTo = :accountId")
    List<TransferEntity> findAllByAccountsFromAndAccountsToJpa(@Param("accountId") Integer accId);
}
