package _42_three_number_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ikechi Ucheagwu
 * @created 02/02/2023 - 00:11
 * @project Algo Github
 */

public class ThreeNumberSum {

    public static void main(String[] args) {
        int[] arr = {12, 3, 1, 2, -6, 5, -8, 6};
        int sum = 0;
        System.out.println(solution(arr, sum));
    }

    private static List<List<Integer>> solution(int[] arr, int sum) {
        Arrays.sort(arr);
        int i = 0;
        int leftPointer = i + 1;
        int rightPointer = arr.length - 1;
        List<List<Integer>> lists = new ArrayList<>();

        while (i <= arr.length - 2) {
            int ele = arr[i];
            int eleTwo = arr[leftPointer];
            int eleThree = arr[rightPointer];

            if (ele + eleTwo + eleThree == sum) {
                lists.add(List.of(ele, eleTwo, eleThree));
                leftPointer += 1;
                rightPointer -= 1;

                if (i == arr.length - 3) {
                    break;
                }
            }

            if (ele + eleTwo + eleThree > sum) {
                rightPointer -= 1;
            } else if (ele + eleTwo + eleThree < sum) {
                leftPointer += 1;
            }

            if (leftPointer >= rightPointer) {
                i += 1;
                leftPointer = i + 1;
                rightPointer = arr.length - 1;
            }
        }

        return lists;
    }
}
