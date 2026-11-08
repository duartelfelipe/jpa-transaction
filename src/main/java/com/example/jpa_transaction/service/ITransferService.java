package com.example.jpa_transaction.service;

import com.example.jpa_transaction.dto.TransferDTO;
import com.example.jpa_transaction.model.Transaction;

public interface ITransferService {
    Transaction transferValues(TransferDTO transfer);
}
