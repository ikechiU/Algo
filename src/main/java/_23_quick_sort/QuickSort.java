package _23_quick_sort;

import java.util.Arrays;

/**
 * @author Ikechi Ucheagwu
 * @created 13/01/2023 - 22:48
 * @project Algo Github
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 0, -10, 20, -3, 1, 100, 150, 40, 33, 55, 66, 11, 15, 40, 77};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
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
}
