package _29_closest_pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ikechi Ucheagwu
 * @created 21/01/2023 - 21:47
 * @project Algo Github
 */

public class ClosestPair {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findClosestPairOptimalSolution(new int[]{32, 71, 12, 45, 26, 80, 34, 43})));
        System.out.println(Arrays.toString(findClosestPair(new int[]{32, 71, 12, 45, 26, 80, 34, 43})));
        System.out.println(findClosestPairGrouped(new int[]{32, 71, 12, 45, 26, 80, 34, 43, 31}));
        System.out.println(findClosestPairGrouped(new int[]{32, 71, 12, 45, 26, 80, 34, 43}));
    }

    //TC -> O(nlogn) + O(n) = O(nlogn + n) === O(nlogn) | SC -> O(1)
    public static int[] findClosestPairOptimalSolution(int[] arr) {
        int[] result = new int[2];
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int eleOne = arr[i];
            int eleTwo = arr[i + 1];

            int diff = Math.abs((eleOne - eleTwo));
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = eleOne;
                result[1] = eleTwo;
            }

        }
        return result;
    }


    //TC -> O(n2) | SC -> O(1)
    public static int[] findClosestPair(int[] arr) {
        int[] closestPair = new int[2];
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = Math.abs(arr[i] - arr[j]);
                if (diff < minDiff) {
                    minDiff = diff;
                    closestPair[0] = arr[i];
                    closestPair[1] = arr[j];
                }
            }
        }
        return closestPair;
    }

    //TC -> O(nlogn) + O(n) = O(nlogn + n) === O(nlogn) | SC -> O(1)
    public static List<List<Integer>> findClosestPairGrouped(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int eleOne = arr[i];
            int eleTwo = arr[i + 1];

            int diff = Math.abs((eleOne - eleTwo));
            if (diff < minDiff) {
                minDiff = diff;
                result = new ArrayList<>();
                addItem(result, eleOne, eleTwo);
            } else if (diff == minDiff) {
                addItem(result, eleOne, eleTwo);
            }

        }
        return result;
    }

    private static void addItem(List<List<Integer>> result, int eleOne, int eleTwo) {
        List<Integer> integers = new ArrayList<>();
        integers.add(eleOne);
        integers.add(eleTwo);
        result.add(integers);
    }

}
