package _25_MaximizeTheValue;

import java.util.Arrays;

/**
 * @author Ikechi Ucheagwu
 * @created 14/01/2023 - 2:26 PM
 * @project AlgoInterview
 */

/*
Rearrange an array of integers so that the calculated value U is maximized. Among the arrangements that satisfy that test,
choose the array with minimal ordering. The value of U for an array with n elements is calculated as:
U = arr[1] x arr[2] x (1 ÷ arr[3]) x arr[4] x ...  x arr[n-1] x (1 ÷ arr[n]) if n is odd
U = arr[1] x arr[2] x (1 ÷ arr[3]) x arr[4] x ... x (1 ÷ arr[n-1]) x arr[n] if n is even
The sequence of operations is the same in either case, but the length of the array, n,
determines whether the calculation ends on arr[n] or (1 ÷ arr[n]).
Arrange the elements to maximize U so the Items are in the numerically smallest possible order.
Example
arr = [21, 34, 5, 7, 9]
To maximize U and minimize the order, arrange the array as [9, 21, 5, 34, 7] so U = 9 x 21 x (1 ÷ 5) x 34 x (1 ÷ 7) = 183.6.
The same U can be achieved using several other orders, eg. [21, 9, 7, 34, 5] = 21 x 9 x (1÷7) x 34 x (1÷5) = 183.6,
but they are not in the minimum order.

Function Description
Complete the function rearrange in the editor.

rearrange has the following parameter(s):
int arr[n]: an array of integers

Returns
int arr[n]: the elements of arr rearranged as described
*/


public class MaximizeTheValue {

    public static void main(String[] args) {
        int[] arr = {};
        int[] arr1 = {21, 34, 5, 7, 9};
        int[] arr2 = {21, 34, 5, 7, 9, 2};
        int[] arr3 = {4, 6, 7, 21, 80, 90, 126};
        int[] arr4 = {1, 2, 3, 4, 5, 6};
        int[] arr5 = {11, 13, 2, 1, 6, 8, 7};
        int[] arr6 = {20};
        int[] arr7 = {20, 88};
        int[] arr8 = {20, 88, 66};
        int[] arr9 = {20, 88, 66, 100};
        System.out.println("Result: " +  Arrays.toString(rearrange(arr)));
        System.out.println("************************************");
        System.out.println("Result1: " +  Arrays.toString(rearrange(arr1)));
        System.out.println("************************************");
        System.out.println("Result2: " +  Arrays.toString(rearrange(arr2)));
        System.out.println("************************************");
        System.out.println("Result3: " +  Arrays.toString(rearrange(arr3)));
        System.out.println("************************************");
        System.out.println("Result4: " +  Arrays.toString(rearrange(arr4)));
        System.out.println("************************************");
        System.out.println("Result5: " +  Arrays.toString(rearrange(arr5)));
        System.out.println("************************************");
        System.out.println("Result6: " +  Arrays.toString(rearrange(arr6)));
        System.out.println("************************************");
        System.out.println("Result7: " +  Arrays.toString(rearrange(arr7)));
        System.out.println("************************************");
        System.out.println("Result8: " +  Arrays.toString(rearrange(arr8)));
        System.out.println("************************************");
        System.out.println("Result9: " +  Arrays.toString(rearrange(arr9)));
    }

    public static int[] rearrange(int[] arr) {
        if (arr.length == 0) return new int[]{};
        int n = arr.length;
        Arrays.sort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));

        int numerator = (n / 2 ) + 1;
        int denominator = n - numerator;

        int[] arrNumerator = new int[numerator];
        int[] arrDenominator = new int[denominator];

        System.arraycopy(arr, arrDenominator.length, arrNumerator, 0, arrNumerator.length);
        System.arraycopy(arr, 0, arrDenominator, 0, arrDenominator.length);

        System.out.println("arrNumerator: " + Arrays.toString(arrNumerator));
        System.out.println("arrDenominator: " + Arrays.toString(arrDenominator));

        System.out.println("numerator: " + numerator);
        System.out.println("denominator: " + denominator);

        int z = 0;
        int j = 0;
        int[] returnValue = new int[arr.length];
        for (int i = 0; i < arrNumerator.length; i++) {
            if (i == 0) {
                returnValue[z] = arrNumerator[0];
                z++;
                continue;
            }

            int eleI = arrNumerator[i];
            returnValue[z] = eleI;
            z++;

            for (int y = j; y < arrDenominator.length; y++) {
                int eleJ = arrDenominator[y];
                returnValue[z] = eleJ;
                j++;
                z++;
                break;
            }

        }


        return returnValue;
    }


}
