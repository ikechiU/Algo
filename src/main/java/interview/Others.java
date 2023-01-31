package interview;

import java.util.Arrays;

/**
 * @author Ikechi Ucheagwu
 * @created 30/01/2023 - 18:32
 * @project Algo Github
 */


public class Others {

    public static void main(String[] args) {
        //two number sum
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        System.out.println(Arrays.toString(solution(array, 11)));
    }

    private static int[] solution(int[] arr, int sum) {
        int[] returnValue = {-1, -1};

        if (arr.length > 1) {
            Arrays.sort(arr);
            int leftPointer = 0;
            int rightPointer = arr.length - 1;

            while (leftPointer < rightPointer) {
                int left = arr[leftPointer];
                int right = arr[rightPointer];

                if (left + right == sum) {
                    returnValue[0] = left;
                    returnValue[1] = right;
                    break;
                }

                if (left + right > sum) {
                    rightPointer--;
                } else {
                    leftPointer++;
                }

            }
        }

        return returnValue;
    }
}
