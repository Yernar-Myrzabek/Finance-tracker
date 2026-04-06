package com.yernar.finance_tracker.service;


import com.yernar.finance_tracker.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yernar.finance_tracker.entity.Transaction;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction save(Transaction transaction){
        return transactionRepository.save(transaction);
    }
    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }
    public float getBalance(){
        List<Transaction> transactions = transactionRepository.findAll();
        float balance=0;
            for(Transaction transaction: transactions){
                if(transaction.getType().equals("INCOME")){
                    balance+=transaction.getAmount();
                }
                else{
                    balance-=transaction.getAmount();
                }
            }
            return balance;

    }
    public void delete(Long id){
        transactionRepository.deleteById(id);
    }

}
