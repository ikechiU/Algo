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
        System.out.println(Arrays.toString(solution(arr, 2)));
    }

    private static int[] solution(int[] arr, int searchNo) {
        int leftPointer = 0;
        int rightPointer = arr.length - 1;


        while (leftPointer != rightPointer) {
            if (arr[leftPointer] == searchNo) {
                leftPointer += 1;
            }

            if (arr[rightPointer] == searchNo) {
                rightPointer -= 1;
            }

            if (arr[rightPointer] != searchNo && arr[leftPointer] != searchNo) {
                leftPointer += 1;
            }

            if (arr[rightPointer] != searchNo && arr[leftPointer] == searchNo) {
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
