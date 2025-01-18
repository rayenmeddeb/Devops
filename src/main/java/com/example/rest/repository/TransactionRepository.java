package com.example.rest.repository;

import com.example.rest.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByUserId(Integer userId);
    List<Transaction> findByTxnType(String txnType);
    
    @Query("SELECT t FROM Transaction t WHERE t.userId = ?1 AND t.timestamp BETWEEN ?2 AND ?3")
    List<Transaction> findByUserIdAndTimestampBetween(Integer userId, Long startTime, Long endTime);
}
