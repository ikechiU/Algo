package org.example._2_find_num;

import java.util.Arrays;

public class FindNum {

    public static void main(String[] args) {

        int[] array = {3, 5, -4, 8, 11, 1, -1, 6, 100, 80, 6, -3, 8, 9, 4, 10, 20, 90, 76, 99, 88, 30, 33, 26, 38, 57};

        System.out.println(findNum(array, 92));
        System.out.println(findNum(array, 30));
    }

    private static boolean findNum(int[] array, int searchedNum) {

        Arrays.sort(array);

        var leftPointer = 0;
        var rightPointer = array.length - 1;

        while (true) {
            int currIn = (leftPointer + rightPointer) / 2;

            if (array[currIn] == searchedNum) {
                return true;
            } else if (leftPointer > rightPointer)
                return false;
            else {
                if (array[currIn] < searchedNum) {
                    leftPointer = currIn + 1;
                } else {
                    rightPointer = currIn - 1;
                }

            }
        }
    }
}
