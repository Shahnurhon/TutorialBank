package com.example.bank.controllers;


import com.example.bank.dto.AccountDto;
import com.example.bank.model.AccountEntity;
import com.example.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/{id}")
    public AccountEntity searchById(@PathVariable Integer id) {
        return accountService.searchById(id);
    }

    @GetMapping
    public List<AccountEntity> findAll() {
        return accountService.findAll();
    }

    @PostMapping
    public AccountEntity newAccount(@RequestBody AccountDto accountDto) {
        AccountEntity account = accountService.createAccount(accountDto);
        return account;
    }

    @PutMapping
    public AccountEntity account(@PathVariable Integer id,
                                 @RequestBody AccountDto accountDto) {
        return accountService.updateAccount(id, accountDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        accountService.deleteAccount(id);
    }
}
