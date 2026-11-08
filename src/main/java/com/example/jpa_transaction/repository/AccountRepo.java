package com.example.jpa_transaction.repository;

import com.example.jpa_transaction.model.Account;
import org.springframework.data.repository.ListCrudRepository;

public interface AccountRepo extends ListCrudRepository<Account, Integer> {
}
