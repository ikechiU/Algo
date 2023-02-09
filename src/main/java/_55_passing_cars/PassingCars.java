package _55_passing_cars;

/**
 * @author Ikechi Ucheagwu
 * @created 07/02/2023 - 10:15
 * @project Algo Github
 */


/*
* A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

For example, consider array A such that:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the number of pairs of passing cars.

The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.

For example, given:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.
*/

public class PassingCars {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 1, 0};
        int[] arr1 = {0, 1, 0, 1, 1, 0};
        int[] arr2 = {0, 0, 0, 0};
        int[] arr3 = {1, 1, 1, 1, 1};
        int[] arr4 = {0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1};
        int[] arr5 = {0, 0, 0, 1, 1, 0, 1, 0, 1};
        System.out.println(passingCars(arr));
        System.out.println(passingCars(arr1));
        System.out.println(passingCars(arr2));
        System.out.println(passingCars(arr3));
        System.out.println(passingCars(arr4));
        System.out.println(passingCars(arr5));
    }

    private static int passingCars(int[] arr) {
        int east = 0;
        int pairs = 0;

        for (int j : arr) {
            if (j == 0) {
                east++;
            } else {
                pairs += east;
            }

            if (pairs > 1_000_000_000) {
                return -1;
            }
        }

        return pairs;
    }
}
