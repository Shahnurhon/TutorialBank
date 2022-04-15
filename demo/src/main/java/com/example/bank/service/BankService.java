package com.example.bank.service;

import com.example.bank.dto.TransferDto;
import com.example.bank.model.TransferBalance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BankService {
    private final TransferService transferService;
    private final AccountService accountService;

    public BigDecimal getBalance(Integer accountId) {
        BigDecimal balance = accountService.getBalanceByAccountId(accountId);
        if (balance == null) {
            throw new IllegalArgumentException();
        }
        return balance;
    }

    public BigDecimal addMoney(Integer accountId, BigDecimal amount) {
        BigDecimal fromBalance = accountService.getBalanceByAccountId(accountId);
        if (fromBalance == null) {
            fromBalance = amount;
        } else {
            fromBalance = amount.add(fromBalance);
        }
        return accountService.updateBalance(accountId, fromBalance);
    }

    public void makeTransfer(TransferBalance transferBalance) {
        BigDecimal fromBalance = accountService.getBalanceByAccountId(transferBalance.getFrom());
        BigDecimal toBalance = accountService.getBalanceByAccountId(transferBalance.getTo());
        if (fromBalance == null || toBalance == null) throw new IllegalArgumentException("no ids");
        if (transferBalance.getAmount().compareTo(fromBalance) > 0) throw new IllegalArgumentException("no money");

        BigDecimal updatedFromBalance = fromBalance.subtract(transferBalance.getAmount());
        BigDecimal updatedToBalance = toBalance.add(transferBalance.getAmount());
        accountService.updateBalance(transferBalance.getFrom(), updatedFromBalance);
        accountService.updateBalance(transferBalance.getTo(), updatedToBalance);
        TransferDto transferDto = new TransferDto();
        transferDto.setAccountsFrom(transferBalance.getFrom());
        transferDto.setAccountsTo(transferBalance.getTo());
        transferDto.setTransferStatus("Success");
        transferDto.setAmount(transferBalance.getAmount());
        transferDto.setTransferTime(Timestamp.valueOf(LocalDateTime.now()));
        transferService.createTransfer(transferDto);

    }
}
