package com.clamaa.algorithm.simple.interview;

/**
 * User: mazhqa
 * Date: 14-3-31
 */
public class PrimeNumber {

    public boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        for (int i = 0; i < 20; i++) {
            if (primeNumber.isPrime(i)) {
                System.out.println(i + " is a prime");
            }
        }

    }

}
