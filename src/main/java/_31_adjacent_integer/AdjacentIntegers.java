package _31_adjacent_integer;

/**
 * @author Ikechi Ucheagwu
 * @created 26/01/2023 - 00:42
 * @project Algo Github
 */


/* Given an array of integers finds and return the index  i of the first integer
* within the array that is less than its adjacent integers on both sides.
* Note that to satisfy these criteria, adjacent integers on both sides must exist.
* Return -1 if none of the integers in the given array fit the criteria.
* Example [1, 2,1, 4] should return -1 and [3, 2, 1, 3, 2] should return 2 */

public class AdjacentIntegers {

    public static void main(String[] args) {
        System.out.println(firstLoneInteger(new int[]{1, 2, 3, 4}));
        System.out.println(firstLoneInteger(new int[]{3, 2, 1, 3, 2}));
    }

    private static int firstLoneInteger(int[] arr) {

        for (int i = 1; i < arr.length - 1; i++) {
            int left = arr[i - 1];
            int right = arr[i + 1];

            if (arr[i] < left && arr[i] < right) {
                return i;
            }

        }

        return -1;
    }

}
