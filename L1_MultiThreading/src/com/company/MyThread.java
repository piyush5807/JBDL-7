package com.company;

public class MyThread extends Thread {

//    static int thread_no;

    BankObj bankObj;
    int amount;
    boolean isDeposit;

    public MyThread(BankObj bankObj, int amount, boolean isDeposit){
        this.bankObj = bankObj;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }


    @Override
    public void run() {
        if(this.isDeposit){
            try {
                deposit();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            try {
                withdraw();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        tempFunc();
//        printThreadNo();
    }

//    public static void printThreadNo(){
//        System.out.println("in thread -" + currentThread().getName() + " thread_no is " + thread_no);
//    }
//    public static void tempFunc(){
//        if(currentThread().getName().equals("Thread-0")) {
//            thread_no = 3;
//        }else if(currentThread().getName().equals("Thread-5")){
//            thread_no = 5;
//        }
//    }

//     write-through
//     write-back

    public void deposit() throws InterruptedException {
        synchronized (BankObj.class) {
            System.out.println("In thread - " + currentThread().getName() + ", deposit function, obj = " + this.bankObj);
            Thread.sleep(5000);
            if(this.bankObj != null) {
                int balance = this.bankObj.getAccountBalance();
                this.bankObj.setAccountBalance(balance + this.amount);
            }
            System.out.println("In thread ending - " + currentThread().getName() + ", deposit function, obj = " + this.bankObj);
        }
    }

    public void withdraw() throws InterruptedException {

        synchronized (BankObj.class) {
            System.out.println("In thread - " + currentThread().getName() + ", withdraw function, obj = " + this.bankObj);
            Thread.sleep(5000);
            if(this.bankObj != null) {
                int balance = this.bankObj.getAccountBalance();
                this.bankObj.setAccountBalance(balance - this.amount);
            }
            System.out.println("In thread ending - " + currentThread().getName() + ", withdraw function, obj = " + this.bankObj);
        }
    }
}
