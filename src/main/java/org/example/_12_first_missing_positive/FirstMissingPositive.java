package org.example._12_first_missing_positive;

import java.util.Arrays;

public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive(new int[]{7, 3, 5, 7, 9}));
        System.out.println(firstMissingPositive(new int[]{0}));
    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int change = 0;

        for (int value : nums) {
            if (value < 0) continue;
            if (value > change + 1) break;
            change = value;
        }

        return change + 1;
    }
}
