package com.example.bank.service;


import com.example.bank.dto.TransferDto;
import com.example.bank.model.TransferEntity;
import com.example.bank.model.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferService {

    @Autowired
    TransferRepository transferRepository;

    public TransferEntity createTransfer(TransferDto transferDto){
        TransferEntity transfer = new TransferEntity();
        transfer.setAccountsFrom(transferDto.getAccountsFrom());
        transfer.setAccountsTo(transferDto.getAccountsTo());
        transfer.setAmount(transferDto.getAmount());
        transfer.setTransferTime(Timestamp.valueOf(LocalDateTime.now()));
        transfer.setTransferStatus(transferDto.getTransferStatus());

        return transferRepository.save(transfer);
    }

    public List<TransferEntity> findAll(){
        return transferRepository.findAll();
    }

    public TransferEntity findId(Integer id){
        return transferRepository.findById(id).orElse(null);
    }

    public List<TransferEntity> searchByFromTo(Integer accountId){
        return transferRepository.findAllByAccountsFromAndAccountsToJpa(accountId);
    }
    public List<TransferEntity> searchByFromFor(Integer accountId){
        return transferRepository.findAllByAccountsFromAndAccountsToNative(accountId);
    }

}
