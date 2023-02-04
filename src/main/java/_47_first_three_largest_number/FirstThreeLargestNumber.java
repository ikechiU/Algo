package _47_first_three_largest_number;

import java.util.Arrays;

/**
 * @author Ikechi Ucheagwu
 * @created 03/02/2023 - 02:16
 * @project Algo Github
 */


public class FirstThreeLargestNumber {

    public static void main(String[] args) {
        int[] arr = {19, 5, 78, 1, 33, 11, 20};
        System.out.println(Arrays.toString(firstThreeLargestNumber(arr)));
    }

    private static int[] firstThreeLargestNumber(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int ele : arr) {
            if (ele > first) {
                third = second;
                second = first;
                first = ele;
            } else if (ele > second) {
                third = second;
                second = ele;
            } else if (ele > third) {
                third = ele;
            }
        }

        return new int[]{first, second, third};
    }
}
