package _18_sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[] {8, 5, 2, 9, 5, 6, 3};
        int[] arr1 = new int[] {8, 5, 2, 9, 5, 6, 3, -20, 3, 90, 1, 0, 17};
//        System.out.println(Arrays.toString(bubbleSort(arr)));
//        System.out.println(Arrays.toString(bubbleSort(arr1)));

        System.out.println(Arrays.toString(selectionSort(arr)));
        System.out.println(Arrays.toString(selectionSort(arr1)));
    }

    private static int[] selectionSort(int[] arr) {
        int startPosition = 0;

        for (int i = startPosition; i < arr.length; i++) {
            int eleI = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                int eleJ = arr[j];

                if (eleJ < eleI) {
                    arr[i] = eleJ;
                    arr[j] = eleI;
                    eleI = eleJ;
                }
            }
            startPosition++;
        }

        return arr;
    }

    private static int[] bubbleSort(int[] arr) {
        int counter = 1;
        boolean isSwapped = true;

        while (isSwapped) {
            isSwapped = false;
            for (int i = 0; i < arr.length - counter; i++) {
                int eleI = arr[i];
                int eleJ = arr[i + 1];

                if (eleI > eleJ) {
                    arr[i] = eleJ;
                    arr[i + 1] = eleI;
                    isSwapped = true;
                }
            }
            counter++;
        }

        return arr;
    }

}
