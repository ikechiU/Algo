package _57_array_inversion_count;

/**
 * @author Ikechi Ucheagwu
 * @created 08/02/2023 - 10:41
 * @project Algo Github
 */

/**
 *An array A consisting of N integers is given. An inversion is a pair of indexes (P, Q) such that P < Q and A[Q] < A[P].
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that computes the number of inversions in A, or returns −1 if it exceeds 1,000,000,000.
 *
 * For example, in the following array:
 *
 *  A[0] = -1 A[1] = 6 A[2] = 3
 *  A[3] =  4 A[4] = 7 A[5] = 4
 * there are four inversions:
 *
 *    (1,2)  (1,3)  (1,5)  (4,5)
 * so the function should return 4.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 **/

public class ArrayInversionCount {

    public static void main(String[] args) {
        int[] arr = {-1, 6, 3, 4, 7, 4};
        System.out.println(mergeSort(arr, 0, arr.length - 1));
    }

    private static int mergeSort(int[] A, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;
        int inversions = mergeSort(A, left, mid) + mergeSort(A, mid + 1, right);

        int[] sorted = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                sorted[k++] = A[i++];
            } else {
                inversions += mid - i + 1;
                sorted[k++] = A[j++];
            }
        }

        while (i <= mid) {
            sorted[k++] = A[i++];
        }
        while (j <= right) {
            sorted[k++] = A[j++];
        }

        for (i = 0; i < sorted.length; i++) {
            A[left + i] = sorted[i];
        }

        if (inversions > 1000000000) return -1;
        return inversions;
    }
}
