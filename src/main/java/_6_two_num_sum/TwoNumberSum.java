package _6_two_num_sum;

import java.util.Arrays;
import java.util.Hashtable;

public class TwoNumberSum {

    //Find the sum of two number to equal  10
    public static void main(String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};

//        hashTableSolution(array);
        var result  = twoPointerMethod(array);
        System.out.println(Arrays.toString(result));
    }

    private static void hashTableSolution(int[] array) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();

        var targetSum = 10;
        int numInHashtable = 0;
        int currentNum = 0;

        // int y = 10 - currentNum;
        for (int num: array) {
            currentNum = num;
            int y = targetSum - currentNum;
            if (hashtable.contains(y)) {
                numInHashtable = hashtable.get(y);
                break;
            } else {
                hashtable.put(currentNum, currentNum);
            }
        }

        int[] twoNumSUm = {numInHashtable, currentNum};
        System.out.println(Arrays.toString(twoNumSUm));
    }

    private static int[] twoPointerMethod(int[] array) {

        Arrays.sort(array);

        int leftCurrIn = 0;
        int rightCurrIn = array.length - 1;

        while (leftCurrIn < rightCurrIn) {
            int leftPointer = array[leftCurrIn];
            int rightPointer = array[rightCurrIn];

            if (leftPointer + rightPointer == 10)
                return new int[]{leftPointer, rightPointer};
            else if (leftPointer + rightPointer < 10)
                leftCurrIn++;
            else if (leftPointer + rightPointer > 10)
                rightPointer--;

        }
        return new int[] {};
    }

}
