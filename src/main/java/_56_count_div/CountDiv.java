package _56_count_div;

/**
 * @author Ikechi Ucheagwu
 * @created 07/02/2023 - 10:24
 * @project Algo Github
 */

/*
 * Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2
* within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.

 */
public class CountDiv {

    public static void main(String[] args) {

        System.out.println(countDiv(0, 2_000_000_000, 2));
        System.out.println(countDiv(6, 11, 2));
        System.out.println(inEfficientWay(0, 2_000_000_000, 2));
        System.out.println(inEfficientWay(6, 11, 2));
    }

    //TC -> 0(1), SC -> 0(1)
    private static int countDiv(int A, int B, int K) {
        int divisible = B/K - A/K;
        if (A % K == 0) {
            divisible++;
        }
        return divisible;
    }

    //TC -> 0(N), SC -> 0(1)
    private static int inEfficientWay(int A, int B, int K) {
        int count = 0;

        for (int i = A; i <= B; i++) {
            if (i % K == 0) count += 1;
        }

        return count;
    }
}
