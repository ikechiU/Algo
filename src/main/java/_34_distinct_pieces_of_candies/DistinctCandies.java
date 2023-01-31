package _34_distinct_pieces_of_candies;

/**
 * @author Ikechi Ucheagwu
 * @created 30/01/2023 - 17:56
 * @project Algo Github
 */

/*
* A man has n=10 distinct pieces of candy. He wants to give five pieces to his son and five pieces to his daughter.
* In how many ways can he do this?*/
public class DistinctCandies {

    public static void main(String[] args) {
        int candies = 10, pieces = 5, people = 2;
        System.out.println(solution(candies, pieces, people));
    }

    private static int solution(int candies, int pieces, int people) {
        int result = combination(candies, pieces);
        return result * people;
    }

    private static int combination(int n, int r) {
        return factorial(n)/(factorial(n - r) * factorial(r));
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
