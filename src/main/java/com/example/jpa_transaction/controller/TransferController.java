package com.example.jpa_transaction.controller;

import com.example.jpa_transaction.dto.TransferDTO;
import com.example.jpa_transaction.model.Transaction;
import com.example.jpa_transaction.service.ITransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private final ITransferService service;

    public TransferController(ITransferService service) {
        super();
        this.service = service;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transfer(@RequestBody TransferDTO transfer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.transferValues(transfer));

    }
}
