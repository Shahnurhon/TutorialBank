package com.example.bank.service;

import com.example.bank.dto.AccountDto;
import com.example.bank.model.AccountEntity;
import com.example.bank.model.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Service

public class  AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<AccountEntity> findAll(){
        return accountRepository.findAll();
    }

    public AccountEntity searchById(Integer id){
        return accountRepository.findById(id).orElse(null);
    }

    public AccountEntity createAccount(AccountDto accountDto){

        AccountEntity account = new AccountEntity();
        account.setUserId(accountDto.getUserId());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());

        return accountRepository.save(account);
    }

    public AccountEntity updateAccount(Integer accountId, AccountDto accountDto) {
        AccountEntity account = accountRepository.findById(accountId).orElse(null);
        if (accountId == null) {
            throw new RuntimeException("Нет такого аккаунта у пользователя");
        }
        account.setUserId(accountDto.getUserId());
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());

        return accountRepository.save(account);
    }

    public void  deleteAccount (Integer id){
        accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Нельзя удалить того чего нет"));
        accountRepository.deleteById(id);
    }

    public BigDecimal getBalanceByAccountId(Integer accountId) {
       return accountRepository.findByBalance(accountId);
    }

    public BigDecimal updateBalance(Integer accountId, BigDecimal fromBalance) {
        accountRepository.updateBalance(fromBalance,accountId);
        return fromBalance;
    }
}


