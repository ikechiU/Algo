package _30_subsequence;

/**
 * @author Ikechi Ucheagwu
 * @created 23/01/2023 - 18:18
 * @project Algo Github
 */

public class SubSequence {

    public static void main(String[] args) {
        int[] arrOne = {5, 1, 22, 25, 6, -1, 8, 10};
        int[] arrTwo = {1, 6, -1, 10}; //i.e. if arrTwo is a subsequence of arrOne

        System.out.println(isSubsequence(arrOne, arrTwo));
    }

    public static void test(int[] arr) {
        //1, 4, 3, 2 => 5, 4, 3, 2
        //5, 7, 9, 4, 11 => 7, 8, 9, 10, 11

        for (int i = arr.length - 1; i >=0; i--) {

        }
    }

    private static boolean isSubsequence(int[] arrOne, int[] arrTwo) {
        int pointer = 0;
        boolean isSubsequence = false;
        for (int eleI : arrOne) {
            int eleJ = arrTwo[pointer];

            if (eleI == eleJ) {
                pointer++;
            }

            if (pointer == arrTwo.length) {
                isSubsequence = true;
                break;
            }
        }
        return isSubsequence;
    }
}
