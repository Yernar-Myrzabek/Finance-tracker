package com.yernar.finance_tracker.controller;


import com.yernar.finance_tracker.entity.Transaction;
import com.yernar.finance_tracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/api/transactions")
    public List<Transaction> getAll(){
        return transactionService.getAll();
    }

    @PostMapping("/api/transactions")
    public Transaction save(@RequestBody Transaction transaction){
        return transactionService.save(transaction);
    }

    @DeleteMapping("/api/transactions/{id}")
    public void delete(@PathVariable Long id){
        transactionService.delete(id);
    }

    @GetMapping("/api/balance")
    public float getBalance(){
        return transactionService.getBalance();
    }
}
