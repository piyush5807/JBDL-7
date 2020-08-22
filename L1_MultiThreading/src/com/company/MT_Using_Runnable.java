package com.company;

public class MT_Using_Runnable {

    public static void main(String[] args) {

        MyThread obj1 = new MyThread();
        Thread thread1 = new Thread(obj1);
        thread1.start();

        MyThread obj2 = new MyThread();
        Thread thread2 = new Thread(obj2);
        thread2.start();

    }

    private static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println("Hello in thread " + Thread.currentThread().getName());
        }
    }
}
