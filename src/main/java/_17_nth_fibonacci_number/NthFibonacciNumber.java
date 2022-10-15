package _17_nth_fibonacci_number;

import java.util.HashMap;

public class NthFibonacciNumber {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};

        System.out.println(findNthFibonacciNumberRecursive1(4));
        System.out.println(findNthFibonacciNumberOptimal(4));
        System.out.println(findNthFibonacciNumberBetterRecursive2(4));
    }

    //Recursively is not optimal because we are doing duplicate computations
    // TC -> O(2^n) // SC -> O(n)
    private static int findNthFibonacciNumberRecursive1(Integer n) {
        if (n == 1)
            return 1;
        else if (n == 0)
            return 0;
        else {
            var fib1 = findNthFibonacciNumberRecursive1(n - 1);
            var fib2 = findNthFibonacciNumberRecursive1(n - 2);

            return fib1 + fib2;
        }
    }

    private static int findNthFibonacciNumberBetterRecursive2(Integer n) {
        return findNthFibonacciNumberBetterRecursive(n, new HashMap<>());
    }


    //TC -> O(n) // SC-> O(n)
    private static int findNthFibonacciNumberBetterRecursive(Integer n, HashMap<Integer, Integer> hashMap) {
        hashMap.put(0, 0);
        hashMap.put(1, 1);

        if (!hashMap.containsKey(n)) {
            var fib1 = findNthFibonacciNumberBetterRecursive(n - 1, hashMap);
            var fib2 = findNthFibonacciNumberBetterRecursive(n - 2, hashMap);

            hashMap.put(n, fib1 + fib2);
        }
        return hashMap.get(n);
    }

    // TC -> O(n) // SC -> 0(1)
    private static int findNthFibonacciNumberOptimal(Integer n) {
        var counter = 3;
        var arrFib = new int[]{0, 1};
        if (n == 1) return 1;
        else if (n == 0) return 0;
        else {
            while (counter <= n){
                int total = arrFib[0] + arrFib[1];
                arrFib[0] = arrFib[1];
                arrFib[1] = total;
                counter += 1;
            }
        }
        return arrFib[0] + arrFib[1];
    }

}
