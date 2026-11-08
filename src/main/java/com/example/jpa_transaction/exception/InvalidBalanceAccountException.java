package com.example.jpa_transaction.exception;

public class InvalidBalanceAccountException extends  RuntimeException{
    public InvalidBalanceAccountException(String message) {
        super(message);
    }
}
