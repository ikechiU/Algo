package org.example._11_bills_100_50_20;

import java.util.ArrayList;

public class BillsChallenge {

    public static void main(String[] args) {
        System.out.println(withdraw(40));
        System.out.println(withdraw(60));
        System.out.println(withdraw(230));
        System.out.println(withdraw(250));
        System.out.println(withdraw(260));
    }

    public static ArrayList<Integer> withdraw(int amount) {
        ArrayList<Integer> result = new ArrayList<>();

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

        result.add(hundredCount);
        result.add(fiftyCount);
        result.add(twentyCount);

        return result;
    }
}
