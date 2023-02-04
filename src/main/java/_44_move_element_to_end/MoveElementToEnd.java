package _44_move_element_to_end;

import java.util.Arrays;

/**
 * @author Ikechi Ucheagwu
 * @created 02/02/2023 - 12:35
 * @project Algo Github
 */

public class MoveElementToEnd {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 4, 2};
        int[] arr2 = {1, 1, 2, 2, 2, 3, 4, 2};
        int[] arr3 = {1, 1, 2, 2, 2, 3, 4, 2};
        int[] arr4 = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] arr5 = {1, 6, 3, 4, 5, 6, 9, 1, 6, 0, 8, 2, 6, 0, 5};
        System.out.println(Arrays.toString(solution(arr, 2)));
        System.out.println(Arrays.toString(solution(arr2, 3)));
        System.out.println(Arrays.toString(solution(arr3, 1)));
        System.out.println(Arrays.toString(solution(arr4, 2)));
        System.out.println(Arrays.toString(solution(arr5, 6)));

        System.out.println(Arrays.toString(solution2(arr, 2)));
        System.out.println(Arrays.toString(solution2(arr2, 3)));
        System.out.println(Arrays.toString(solution2(arr3, 1)));
        System.out.println(Arrays.toString(solution2(arr4, 2)));
        System.out.println(Arrays.toString(solution2(arr5, 6)));
    }


    private static int[] solution(int[] arr, int numToRearrange) {
        int leftPointer = 0;
        int rightPointer = arr.length - 1;

        while (leftPointer < rightPointer) {
            if (arr[rightPointer] == numToRearrange) {
                rightPointer -= 1;
            }

            if (arr[rightPointer] != numToRearrange && arr[leftPointer] != numToRearrange) {
                leftPointer += 1;
            }

            if (arr[rightPointer] != numToRearrange && arr[leftPointer] == numToRearrange) {
                int eleLeft = arr[leftPointer];
                int eleRight = arr[rightPointer];

                arr[leftPointer] = eleRight;
                arr[rightPointer] = eleLeft;
                leftPointer += 1;
                rightPointer -= 1;
            }

        }
        return arr;
    }

    private static int[] solution2(int[] arr, int numToRearrange) {
        int leftPointer = 0;
        int rightPointer = arr.length - 1;

        while (leftPointer < rightPointer) {
            if (arr[leftPointer] == numToRearrange) {
                leftPointer += 1;
            }

            if (arr[rightPointer] != numToRearrange && arr[leftPointer] != numToRearrange) {
                rightPointer -= 1;
            }

            if (arr[leftPointer] != numToRearrange && arr[rightPointer] == numToRearrange) {
                int eleLeft = arr[leftPointer];
                int eleRight = arr[rightPointer];

                arr[leftPointer] = eleRight;
                arr[rightPointer] = eleLeft;
                leftPointer += 1;
                rightPointer -= 1;
            }

        }
        return arr;
    }
}
