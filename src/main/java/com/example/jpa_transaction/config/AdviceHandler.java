package com.example.jpa_transaction.config;

import com.example.jpa_transaction.dto.AdviceDTO;
import com.example.jpa_transaction.exception.InvalidAccountException;
import com.example.jpa_transaction.exception.InvalidBalanceAccountException;
import com.example.jpa_transaction.exception.InvalidTransferException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class AdviceHandler {

    @ExceptionHandler(InvalidAccountException.class)
    public ResponseEntity<AdviceDTO> handleInvalidAccount(InvalidBalanceAccountException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AdviceDTO(ex.getMessage()));
    }

    @ExceptionHandler(InvalidBalanceAccountException.class)
    public ResponseEntity<AdviceDTO> handleInvalidBalanceAccount(InvalidBalanceAccountException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AdviceDTO(ex.getMessage()));
    }

    @ExceptionHandler(InvalidTransferException.class)
    public ResponseEntity<AdviceDTO> handleInvalidTransfer(InvalidTransferException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AdviceDTO(ex.getMessage()));
    }

}
