package com.example.bank.service;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Repository
public class BankRepository {

    private final static Map<Long, BigDecimal> storage;

    static {
        storage = new HashMap<>();
        storage.put(1L, BigDecimal.ZERO);
        storage.put(2L, new BigDecimal("100.0"));
    }


    public BigDecimal getBalanceForId(Long accountId) {
        return storage.get(accountId);
    }

    public BigDecimal save(Long to, BigDecimal amount) {
        storage.put(to, amount);
        return amount;
    }
}
