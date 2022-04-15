package com.example.bank.controllers;

import com.example.bank.dto.TransferDto;
import com.example.bank.model.TransferEntity;
import com.example.bank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {

    @Autowired
    TransferService transferService;

    @GetMapping("/{id}")
    public TransferEntity searchById(@PathVariable("id") Integer id) {
        return transferService.findId(id);
    }

    @GetMapping
    public List<TransferEntity> allTransfer() {
        return transferService.findAll();
    }

    @PostMapping
    public TransferEntity createTransfer(@RequestBody TransferDto transferDto) {
        return transferService.createTransfer(transferDto);
    }

    @GetMapping("/search/{id}")
    public List<TransferEntity> searchByTransfer(@PathVariable("id") Integer id){
        return transferService.searchByFromTo(id);
    }

    @GetMapping("/searchfor/{accountId}")
    public List<TransferEntity> searchByTransferFor(@PathVariable("accountId") Integer accountId){
        return transferService.searchByFromFor(accountId);
    }


}
