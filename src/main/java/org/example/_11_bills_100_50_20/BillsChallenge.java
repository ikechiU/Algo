package org.example._11_bills_100_50_20;

import java.util.Arrays;

public class BillsChallenge {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(withdraw(40)));
        System.out.println(Arrays.toString(withdraw(60)));
        System.out.println(Arrays.toString(withdraw(230)));
        System.out.println(Arrays.toString(withdraw(250)));
        System.out.println(Arrays.toString(withdraw(260)));
    }

    public static int[] withdraw(int n) {
        int hundredCount = 0;
        int fiftyCount = 0;
        int twentyCount;

        if (n % 20 == 10) {
            fiftyCount++;
            n = n - 50;
        }
        if (n >= 100) {
            hundredCount = n / 100;
            n = n - (hundredCount * 100);
        }
        twentyCount = n / 20;

        return new int[] {hundredCount, fiftyCount, twentyCount};
    }
}
