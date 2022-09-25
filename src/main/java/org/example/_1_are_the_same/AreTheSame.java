package org.example._1_are_the_same;

import java.util.Arrays;


//Given two arrays a and b write a function comp(a, b) (orcompSame(a, b))
// that checks whether the two arrays have the "same" elements, with the
// same multiplicities (the multiplicity of a member is the number of times it appears).
// "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.
//
//Example Valid arrays
//a = [121, 144, 19, 161, 19, 144, 19, 11]
//b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]
//comp(a, b) returns true because in b 121 is the square of 11,
// 14641 is the square of 121, 20736 the square of 144, 361 the square of 19,
// 25921 the square of 161, and so on. It gets obvious if we write b's elements in terms of squares:
//
//a = [121, 144, 19, 161, 19, 144, 19, 11]
//b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]

public class AreTheSame {

    public static void main(String[] args) {
        int[] a = {121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = {121, 14641, 20736, 361, 25921, 361, 20736, 361};

        System.out.println(comp(a, b));

        int[] a1 = {2, -4, 5, 12, 11, 6, 7, -9};
        int[] b1 = {4, 16, 25, 121, 36, 49, 81, 144};

        System.out.println(comp(a1, b1));

    }

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null)
            return false;

        if (a.length == 0 && b.length == 0)
            return true;

        if (a.length < b.length) return false;

        for (int i = 0; i < a.length; i++) {
            a[i] = Math.abs(a[i]);
        }

        Arrays.sort(a);
        Arrays.sort(b);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));


        for (int i = 0; i < a.length; i++) {
            int aSqr = a[i] * a[i];

            if(b[i] != aSqr)
                return false;
        }

        return true;

    }
}
