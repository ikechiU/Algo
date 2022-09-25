package org.example._4_is_prime;

public class IsPrime {

    public static void main(String[] args) {

        System.out.println(isPrime(2));
        System.out.println(isPrime(1));
        System.out.println(isPrime(7));
        System.out.println(isPrime(75));
        System.out.println(isPrime(77));
        System.out.println(isPrime(0));
    }

    public static boolean isPrime(int num) { // copied from geeksforgeeks
        if (num <= 1) return false;
        if (num <= 3) return true;

        if (num % 2 == 0 || num % 3 == 0)
            return false;

        for (int i = 5; i * i <= num; i = i + 6)
            if (num % i == 0 || num % (i + 2) == 0)
                return false;

        return true;
    }
}
