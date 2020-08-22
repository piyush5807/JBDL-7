package com.company;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {

        int[]arr = {10000, 20000, 30000, 6000, 7700, 4000, 5000, 7000, 15000, 40000, 5000, 7000, 40000, 30000};

        long start = System.currentTimeMillis();

        for(int i=0;i<arr.length;i++){
            System.out.println(calculate(arr[i]));
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken to run program is " + (end - start));
    }

    public static BigInteger calculate(int num){

        BigInteger result = BigInteger.ONE;
        for(int i=2;i<=num;i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
