package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyThread obj1 = new MyThread();
        MyThread obj2 = new MyThread();

        obj1.start();
        obj2.start();

        System.out.println(Thread.currentThread().getName());
    }

    private static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("Hello in thread " + currentThread().getName());
        }
    }
}
