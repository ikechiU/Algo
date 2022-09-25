package org.example._9_super_market_queue;

import java.util.Arrays;

public class SuperMarketQueue {

    public static void main(String[] args) {
        System.out.println(solveSuperMarketQueue(new int[]{5,3,4}, 1)); //12
        System.out.println(solveSuperMarketQueue(new int[]{10,2,3,3}, 2));  //10
        System.out.println(solveSuperMarketQueue(new int[]{2,3,10}, 2));  //12
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        int[] queues = new int[n];

        for (int cusElem : customers) {
            queues[0] += cusElem;
            Arrays.sort(queues);
        }

        return queues[queues.length - 1];
    }
}
