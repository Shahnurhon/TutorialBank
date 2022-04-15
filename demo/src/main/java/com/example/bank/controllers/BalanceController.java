package com.example.bank.controllers;

import com.example.bank.model.TransferBalance;
import com.example.bank.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping("/api/balance")
@RestController("balance")
@AllArgsConstructor
public class BalanceController {

    private final BankService bankService;

    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Integer accountId) {
        return bankService.getBalance(accountId);

    }

    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalace) {
        return bankService.addMoney(transferBalace.getTo(), transferBalace.getAmount());

    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBalance transferBalace) {
        bankService.makeTransfer(transferBalace);

    }

}

