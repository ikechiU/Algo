package _54_n_counters;

import java.util.Arrays;

/**
 * @author Ikechi Ucheagwu
 * @created 07/02/2023 - 02:22
 * @project Algo Github
 */

/*
* You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
*/

public class NCounters {

    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 6, 1, 4, 4};
        System.out.println(Arrays.toString(solution(5, arr)));
    }

    public static int[] solution(int N, int[] A) {
        int[] counters = new int[N];

        int maxCounter = 0;
        int lastMax = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= N) {
                if (counters[A[i] - 1] < lastMax) {
                    counters[A[i] - 1] = lastMax;
                }
                counters[A[i] - 1]++;
                maxCounter = Math.max(maxCounter, counters[A[i] - 1]);
            } else {
                lastMax = maxCounter;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < lastMax) {
                counters[i] = lastMax;
            }
        }

        return counters;
    }
}


