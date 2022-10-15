package _4_non_constructible_change;

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String[] args) {

        int [] arr = {}; //1
        int [] arr1 = {1, 1}; //3
        int [] arr2 = {1, 2, 5}; //4
        int [] arr3 = {2, 3, 5}; //1
        int [] arr4 = {5, 7, 1, 1, 2, 3, 22}; //20
        int [] arr5 = {1, 1, 3}; //6


        System.out.println(nonConstructibleChange(arr));
        System.out.println(nonConstructibleChange(arr1));
        System.out.println(nonConstructibleChange(arr2));
        System.out.println(nonConstructibleChange(arr3));
        System.out.println(nonConstructibleChange(arr4));
        System.out.println(nonConstructibleChange(arr5));

    }

    //Time = O(nlogn)  //Space = O(1) because we are mutating it, using the same space
    //If we are not allowed to sort it we will create a new data structure to store it O(n)
    private static int nonConstructibleChange(int[] arr) {

        if (arr.length == 0)
            return 1;

        Arrays.sort(arr);
        var change = 0;

        for (int value : arr) {
            if (value > change + 1)
                break;
            change += value;
        }

        return change + 1;
    }
}
