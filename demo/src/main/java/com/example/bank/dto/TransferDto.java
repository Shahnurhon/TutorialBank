package com.example.bank.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class TransferDto {

    private Integer id;
    private Integer accountsFrom;
    private Integer accountsTo;
    private BigDecimal amount;
    private Timestamp transferTime;
    private String transferStatus;
}
