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

    public static int[] withdraw(int amount) {
        int hundredCount = 0;
        int fiftyCount = 0;
        int twentyCount = 0;

        if (amount % 20 == 0) {
            if (amount >= 100) {
                hundredCount = amount / 100;
                amount = amount - (hundredCount * 100);
            }
            twentyCount = amount / 20;
        }

        if (amount % 20 == 10) {
            fiftyCount++;
            amount = amount - 50;
            if (amount >= 100) {
                hundredCount = amount / 100;
                amount = amount - (hundredCount * 100);
            }
            twentyCount = amount / 20;
        }


        return new int[] {hundredCount, fiftyCount, twentyCount};
    }
}
