package com.example.jpa_transaction.model;

import com.example.jpa_transaction.exception.InvalidBalanceAccountException;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    private Integer number;
    @Column(name = "balance")
    private Double balance;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        if (balance < 0) {
            throw new InvalidBalanceAccountException("Account #" + this.number + " - balance cannot be negative");
        }
        this.balance = balance;
    }
}