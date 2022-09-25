package org.example._5_sorted_square;

import java.util.Arrays;

public class SortedSquareArray {

    public static void main(String[] args) {

        int[] array = {-8, -6, -2, 1, 2, 3};

        //bruteForce(array); //Time = O(n Log n); //Space = O(n)
        moreOptimalWay(array); //Time = O(n);  //Space = O(n)

    }

    private static void bruteForce(int[] array) {
        int[] newArr = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i] * array[i];
        }

        Arrays.sort(newArr);

        System.out.println(Arrays.toString(newArr));
    }

    private static void moreOptimalWay(int[] array) { //Array is already sorted.

        int[] newArr = new int[array.length];

        var lowestIn = 0;
        var largestIn = array.length - 1;

        for (int i = array.length - 1; i >= 0; i--) {

            var smallestValue = array[lowestIn];
            var largestValue = array[largestIn];

            if (Math.abs(smallestValue) > Math.abs(largestValue)) {
                newArr[i] = smallestValue * smallestValue;
                lowestIn += 1;
            } else {
                newArr[i] = largestValue * largestValue;
                largestIn -= 1;
            }

        }

        System.out.println(Arrays.toString(newArr));
    }


}
