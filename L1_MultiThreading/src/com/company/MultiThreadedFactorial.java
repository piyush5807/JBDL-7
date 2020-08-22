package com.company;

import java.math.BigInteger;

public class MultiThreadedFactorial {

    public static void main(String[] args) throws InterruptedException {

        int MAX_VALUE_ACCEPTED = 10000;

        int[]arr = {10000, 400000, 20000, 30000, 6000, 7700, 4000, 5000, 7000, 15000, 40000, 5000, 7000, 40000, 30000, 455555};

        long start = System.currentTimeMillis();

        MyThread[] threads = new MyThread[arr.length];

        for(int i=0;i<arr.length;i++){

            threads[i] = new MyThread(arr[i]);
            if(arr[i] > MAX_VALUE_ACCEPTED){
                threads[i].setPriority(2);
            }
            threads[i].start();

        }


        for(int i=0;i<arr.length;i++){
            threads[i].join(200);
            System.out.println(arr[i] + " is completed yet ??" + threads[i].isAlive());
            threads[i].stop();
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken to run program is " + (end - start));
    }

    private static class MyThread extends Thread{

        int num;
        BigInteger result;

        public BigInteger getResult(){
            return this.result;
        }

        MyThread(int num){
            this.num = num;
            this.result = BigInteger.ONE;
        }

        @Override
        public void run() {
            calculate();
            System.out.println(this.num + " is calculated and here is the result - " + result);
        }

        public void calculate(){

            for(int i=2;i<=this.num;i++){
                this.result = this.result.multiply(BigInteger.valueOf(i));
            }
        }
    }
}
