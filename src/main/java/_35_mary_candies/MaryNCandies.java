package _35_mary_candies;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ikechi Ucheagwu
 * @created 30/01/2023 - 18:12
 * @project Algo Github
 */

/*
* Mary has N candies. The i-th candy is of a type represented by an integer T[i].
Mary's parents told her to share the candies with her brother. She must give him exactly half the
candies. Fortunately, the number of candies N is even.
After giving away half the candies, Mary will eat the remaining ones. She likes variety, so she wants
to have candies of various types. Can you find the maximum number of different types of candy that
Mary can eat?
Write a function:
int solution (int T[], int N);
that, given an array T of N integers, representing all the types of candies, returns the maximum
possible number of different types of candy that Mary can eat after she has given N/2 candies to her
brother.
For example, given:
T = (3, 4, 7, 7, 6, 6]
the function should return 3. One optimal strategy for Mary is to give away one candy of type 4, one
of type 7 and one of type 6. The remaining candies would be [3, 7, 6]: three candies of different types.
Given:
T
= [80, 80, 1000000000, 80, 80, 80, 80, 80, 80, 123456789]
the function should also return 3. Here, Mary starts with ten candies. She can give away five candies
of type 80 and the remaining candies would be [1000000000, 123456789, 80, 80, 80]. There
are only three different types in total, i.e. 80, 1000000000 and 123456789.
Write an efficient algorithm for the following assumptions:
Nis an integer within the range [2..100,000];
N is even;
each element of array T is an integer within the range [1..1,000.000.0001.*/

public class MaryNCandies {

    public static void main(String[] args) {
        int[] t  = {3, 4, 7, 7, 6, 6}, t2 = {80, 80, 1000000000, 80, 80, 80, 80, 80, 80, 123456789}, t3 = {6, 6, 6, 6};
        int n  = t.length, n2 = t2.length, n3 = t3.length;
        System.out.println(solution(t, n)); //OUTPUT -> 3
        System.out.println(solution(t2, n2)); //OUTPUT -> 3
        System.out.println(solution(t3, n3)); //OUTPUT -> 1
    }

    private static int solution(int[] t, int n) {
        int candiesHalf = n / 2;
        Set<Integer> set = new HashSet<>();
        for (int j : t) {
            set.add(j);
        }
        return Math.min(set.size(), candiesHalf);
    }
}
