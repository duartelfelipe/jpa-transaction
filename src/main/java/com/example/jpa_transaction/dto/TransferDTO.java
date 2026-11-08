package com.example.jpa_transaction.dto;

public record TransferDTO(Integer debitAccount, Integer creditAccount, Double amount) {
}
