package _5_sorted_square;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ikechi Ucheagwu
 * @created 23/01/2023 - 18:46
 * @project Algo Github
 */

public class Sorted2 {

    public static void main(String[] args) {

        int[] array = {-8, -6, -2, 1, 2, 3};
        System.out.println(binarySearch(array, -6));
//        System.out.println(Arrays.toString(moreOptimalWay(array)));
        int[] arr = {2, 4, 0, -10, 20, -3, 1, 100, 150, 40, 33, 55, 66, 11, 15, 40, 77};
        System.out.println(Arrays.toString(quickSort(arr, 0, arr.length - 1)));

    }

    private static int[] moreOptimalWay(int[] array) {
        int leftPointer = 0;
        int rightPointer = array.length - 1;

        int[] returnValue = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int rightIndexElement = Math.abs(array[rightPointer]);
            int leftIndexElement = Math.abs(array[leftPointer]) ;

            if (leftIndexElement > rightIndexElement) {
                returnValue[i] = leftIndexElement * leftIndexElement;
                leftPointer += 1;
            } else {
                returnValue[i] = rightIndexElement * rightIndexElement;
                rightPointer -= 1;
            }
        }

        return returnValue;
    }

    public static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(low, high, arr);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
        return arr;
    }

    private static int partition(int low, int high, int[] arr) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    public static boolean binarySearch(int[] arr, int searchValue) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while (true) {
            int currIndex = leftIndex + rightIndex / 2;

            if (arr[currIndex] == searchValue) {
                return true;
            } else if (leftIndex > rightIndex) {
                return false;
            } else  {
                if ((arr[currIndex] < searchValue)) {
                    leftIndex = currIndex + 1;
                } else {
                    rightIndex = currIndex - 1;
                }
            }
        }
    }
}

