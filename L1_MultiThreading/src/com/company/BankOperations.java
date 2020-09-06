package com.company;

public class BankOperations {

    public static void main(String[] args) throws InterruptedException {

        BankObj obj1 = new BankObj(1, 1000);
        BankObj obj2 = new BankObj(2, 500);

        MyThread[]threads = new MyThread[6];

        threads[0] = new MyThread(obj1, 100, false);
        threads[1] = new MyThread(obj1, 50, true);
        threads[2] = new MyThread(obj1, 150, false);


        threads[3] = new MyThread(obj2, 200, true);
        threads[4] = new MyThread(obj2, 100, false);
        threads[5] = new MyThread(obj2, 250, true);

        for(int i=0;i<6;i++){
            threads[i].start();
        }


        for(int i=0;i<threads.length;i++){
            threads[i].join();
        }

        System.out.println(obj1.getAccountBalance() + " " + obj2.getAccountBalance());
    }


    // Thread 0, 1, 2 - Obj 1
    // Thread 3, 4, 5 - Obj 2

    private static class MyThread extends Thread {

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
        }

        public void deposit() throws InterruptedException {
            synchronized (BankObj.class) {
                System.out.println("In thread - " + currentThread().getName() + ", deposit function, obj = " + this.bankObj);
                Thread.sleep(5000);
                int balance = this.bankObj.getAccountBalance();
                this.bankObj.setAccountBalance(balance + this.amount);
                System.out.println("In thread ending - " + currentThread().getName() + ", deposit function, obj = " + this.bankObj);
            }
        }

        public void withdraw() throws InterruptedException {

            synchronized (BankObj.class) {
                System.out.println("In thread - " + currentThread().getName() + ", withdraw function, obj = " + this.bankObj);
                Thread.sleep(5000);
                int balance = this.bankObj.getAccountBalance();
                this.bankObj.setAccountBalance(balance - this.amount);
                System.out.println("In thread ending - " + currentThread().getName() + ", withdraw function, obj = " + this.bankObj);
            }
        }

    }


}
