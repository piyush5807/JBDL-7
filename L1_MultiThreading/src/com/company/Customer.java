package com.company;

public class Customer {

    private int customerId;
    private int balance;

    public Customer(int customerId, int balance) {
        this.customerId = customerId;
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
