package com.company;

public class BankObj {

    private int accountNo;
    private int accountBalance;

    public BankObj(int accountNo, int accountBalance) {
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

//    @Override
//    public String toString() {
//        return "BankObj{" +
//                "accountNo=" + accountNo +
//                '}';
//    }
}
