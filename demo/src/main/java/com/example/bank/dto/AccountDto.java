package com.example.bank.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private Integer id;
    private Integer userId;
    private String accountNumber;
    private BigDecimal balance;

}
