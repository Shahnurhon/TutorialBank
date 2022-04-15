package com.example.bank.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferBalance {

    private Integer from;
    private Integer to;
    private BigDecimal amount;


}
