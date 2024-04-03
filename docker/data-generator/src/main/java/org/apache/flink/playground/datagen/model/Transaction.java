package org.apache.flink.playground.datagen.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/** A simple financial transaction. */
public class Transaction implements Serializable {
    private long accountId;
    private int amount;
    private LocalDateTime timestamp;

    // Default constructor required by Avro
    public Transaction() {
    }

    public Transaction(long accountId, int amount, LocalDateTime timestamp) {
        this.accountId = accountId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    // Getters and setters required by Avro
    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Override toString() method for better representation
    @Override
    public String toString() {
        return "Transaction{" +
                "accountId=" + accountId +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}
