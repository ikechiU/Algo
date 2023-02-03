package _37_three_largest_number;

import java.util.Arrays;

/**
 * @author Ikechi Ucheagwu
 * @created 01/02/2023 - 12:12
 * @project Algo Github
 */

public class ThreeLargestNumber {

    public static void main(String[] args) {
        int[] arr = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        System.out.println(Arrays.toString(solution(arr)));
    }

    private static int[] solution(int[] arr) {
        int[] returnValue = new int[3];

        for (int ele : arr) {
            shiftAndUpdate(returnValue, ele);
        }

        return returnValue;
    }

    private static void shiftAndUpdate(int[] returnValue, int ele) {
        int eleOne = returnValue[1];
        int eleTwo = returnValue[2];

        if (ele > returnValue[2]) {
            returnValue[2] = ele;
            returnValue[1] = eleTwo;
            returnValue[0] = eleOne;
            return;
        }
        if (ele > returnValue[1]) {
            returnValue[1] = ele;
            returnValue[0] = eleOne;
            return;
        }
        if (ele > returnValue[0]) {
            returnValue[0] = ele;
        }
    }
}
