package _59_no_of_ways_of_making_change;

/**
 * @author Ikechi Ucheagwu
 * @created 18/02/2023 - 12:19
 * @project Algo Github
 * /

/**
 * Number of ways of making change; given an amount and array of current denomination.
 * E.g. int amount = $10; int[] denos = {1, 5, 10, 25};
 * Solution = 4 => 10 of $1; 2 of $5; 5 of $1 and 1 of $5; 1 of $10
 * Solution is done with dynamic programming.
 * Initialize an array ways of amount + 1 with ways[0] = 1 i.e.
 * int[] ways = new int[amount + 1] then ways[0] = 1; ways = {1, 0, 0, 0, 0, 0 , 0, 0, 0, 0, 0};
 * Then iterate over denos while iterating from i = 1 to i < amount + 1;
 * check if deno[i] <= i then ways[i] += ways[i - deno[i]];
 */
public class NumberOfWaysOfMakingChange {

    public static void main(String[] args) {
        int amount = 10;
        int amount2 = 5;
        int amount3 = 0;
        int amount4 = 25;
        int[] denominations = {1, 5, 10, 25};

        System.out.println(numberOfWaysOfMakingChange(amount, denominations));
        System.out.println(numberOfWaysOfMakingChange(amount2, denominations));
        System.out.println(numberOfWaysOfMakingChange(amount3, denominations));
        System.out.println(numberOfWaysOfMakingChange(amount4, denominations));
    }

    //TC = O(Nd) where d is the denominators
    private static int numberOfWaysOfMakingChange(int amount, int[] denominations) {
        int[] ways = new int[amount + 1];
        ways[0] = 1;

        for (int bill : denominations) {
            for (int i = 1; i < amount + 1; i++) {
                if (bill <= i) {
                    ways[i] += ways[i - bill];
                }
            }
        }

        return ways[amount];
    }
}
