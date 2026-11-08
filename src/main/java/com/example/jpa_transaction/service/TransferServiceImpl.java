package com.example.jpa_transaction.service;

import com.example.jpa_transaction.dto.TransferDTO;
import com.example.jpa_transaction.exception.InvalidAccountException;
import com.example.jpa_transaction.model.Account;
import com.example.jpa_transaction.model.Transaction;
import com.example.jpa_transaction.repository.AccountRepo;
import com.example.jpa_transaction.repository.TransactionRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransferServiceImpl implements ITransferService {

    private final AccountRepo accountRepo;
    private final TransactionRepo transactionRepo;

    public TransferServiceImpl(AccountRepo accountRepo, TransactionRepo transactionRepo) {
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }

    @Override
    @Transactional
    public Transaction transferValues(TransferDTO transfer) {

        Account src = accountRepo.findById(transfer.debitAccount()).orElseThrow(
                () -> new InvalidAccountException("Invalid debit account number: #" + transfer.debitAccount())
        );

        Account dst = accountRepo.findById(transfer.creditAccount()).orElseThrow(
                () -> new InvalidAccountException("Invalid credit account number: #" + transfer.creditAccount())
        );

        dst.setBalance(dst.getBalance() + transfer.amount());
        accountRepo.save(dst);
        IO.println("Credit account #" + dst.getNumber() + "new balance: " + dst.getBalance());

        src.setBalance(src.getBalance() - transfer.amount());
        accountRepo.save(src);
        IO.println("Debit account #" + src.getNumber() + "new balance: " + src.getBalance());

        Transaction transaction = new Transaction();
        transaction.setDebitAccount(src);
        transaction.setCreditAccount(dst);
        transaction.setAmount(transfer.amount());
        transaction.setTimestamp(LocalDateTime.now());
        return transactionRepo.save(transaction);
    }
}
