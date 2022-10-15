package _13_minimum_waiting_time;

import java.util.Arrays;

public class MinimumWaitingTime {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 6};
        //solutionOne(arr);
        optimalSolution(arr);
    }

    // TC -> O(nlogn) + O(n2) ; SC -> O(i)
    private static void solutionOne(int[] arr) {
        Arrays.sort(arr); // TC -> O(nlogn)
        int count = 0; // SC -> O(K)

        for (int i = 0; i < arr.length; i++) { // TC -> O(n)
            if (i != 0)
                for (int j = 0; j < i; j++) { // TC -> O(n)
                    count += arr[j];
                }
        }

        System.out.println(count);
    }

    private static void optimalSolution(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int eleRemaining = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];
            count += (eleRemaining - i) * ele;
        }

        System.out.println(count);
    }
}
