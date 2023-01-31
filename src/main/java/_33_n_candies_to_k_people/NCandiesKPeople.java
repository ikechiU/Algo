package _33_n_candies_to_k_people;

import java.util.Arrays;

/**
 * @author Ikechi Ucheagwu
 * @created 30/01/2023 - 17:22
 * @project Algo Github
 */


/*
* Given N candies and K people. In the first turn, the first person gets 1 candy, the second gets 2 candies, and so on
* till K people. In the next turn, the first person gets K+1 candies, the second person gets k+2 candies, and so on.
* If the number of candies is less than the required number of candies at every turn, then the person receives the
* remaining number of candies.
The task is to find the total number of candies every person has at the end. */

public class NCandiesKPeople {

    public static void main(String[] args) {

        //Input: N = 7, K = 4
        //Output: 1 2 3 1

        //Input: N = 10, K = 3
        //Output: 5 2 3


        int n1 = 7, k1 = 4;
        int n2 = 10, k2 = 3;

        System.out.println(Arrays.toString(solution(n1, k1)));
        System.out.println(Arrays.toString(solution(n2, k2)));
    }

    private static int[] solution(int n, int k) {
        int[] returnValue = new int[k];
        int j = 1;
        while (n > 0) {
            for (int i = 0; i < returnValue.length; i++) {
                if (n >= j) {
                    returnValue[i] = returnValue[i] + j;
                } else {
                    returnValue[i] = returnValue[i] + n;
                }

                n -= j;
                j++;

                if (n <= 0) break;
            }
        }

        return returnValue;
    }
}
