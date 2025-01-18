package com.example.rest.controller;

import com.example.rest.model.Transaction;
import com.example.rest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;
    
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Integer id) {
        return transactionService.getTransactionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/user/{userId}")
    public List<Transaction> getTransactionsByUserId(@PathVariable Integer userId) {
        return transactionService.getTransactionsByUserId(userId);
    }
    
    @GetMapping("/type/{txnType}")
    public List<Transaction> getTransactionsByType(@PathVariable String txnType) {
        return transactionService.getTransactionsByType(txnType);
    }
    
    @GetMapping("/user/{userId}/timerange")
    public List<Transaction> getTransactionsByUserIdAndTimeRange(
            @PathVariable Integer userId,
            @RequestParam Long startTime,
            @RequestParam Long endTime) {
        return transactionService.getTransactionsByUserIdAndTimeRange(userId, startTime, endTime);
    }
    
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }
}
