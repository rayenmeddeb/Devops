package com.example.rest.service;

import com.example.rest.model.Transaction;
import com.example.rest.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    
    public Optional<Transaction> getTransactionById(Integer id) {
        return transactionRepository.findById(id);
    }
    
    public List<Transaction> getTransactionsByUserId(Integer userId) {
        return transactionRepository.findByUserId(userId);
    }
    
    public List<Transaction> getTransactionsByType(String txnType) {
        return transactionRepository.findByTxnType(txnType);
    }
    
    public List<Transaction> getTransactionsByUserIdAndTimeRange(Integer userId, Long startTime, Long endTime) {
        return transactionRepository.findByUserIdAndTimestampBetween(userId, startTime, endTime);
    }
    
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
