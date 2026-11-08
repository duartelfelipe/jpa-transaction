package com.example.jpa_transaction.repository;

import com.example.jpa_transaction.model.Transaction;
import org.springframework.data.repository.ListCrudRepository;

public interface TransactionRepo extends ListCrudRepository<Transaction, Integer> {
}
