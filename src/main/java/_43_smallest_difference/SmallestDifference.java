package _43_smallest_difference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ikechi Ucheagwu
 * @created 02/02/2023 - 10:37
 * @project Algo Github
 */

public class SmallestDifference {

    public static void main(String[] args) {

        int[] arr1 = {-1, 5, 26, 10, 20, 28, 3};
        int[] arr2 = {26, 28, 134, 135, 15, 17};

        System.out.println(solution(arr1, arr2));
    }

    private static List<List<Integer>> solution(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> lists = new ArrayList<>();

        int arr1Pointer = 0;
        int arr2Pointer = 0;

        while (arr1Pointer < arr1.length && arr2Pointer < arr2.length) {
            int eleArr1 = arr1[arr1Pointer];
            int eleArr2 = arr2[arr2Pointer];
            int diff;

            if (eleArr1 < eleArr2) {
                diff = eleArr2 - eleArr1;
                arr1Pointer += 1;
            } else {
                diff = eleArr1 - eleArr2;
                arr2Pointer += 1;
            }

            if (diff < minDiff) {
                minDiff = diff;
                lists.clear();
                lists.add(List.of(eleArr1, eleArr2));
            } else if (diff == minDiff) {
                lists.add(List.of(eleArr1, eleArr2));
            }
        }

        return lists;
    }
}
