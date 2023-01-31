package _1_are_the_same;

import java.util.Arrays;

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
        if (a == null || b == null || (a.length < b.length) ||(b.length < a.length) )
            return false;

        if (a.length == 0)
            return true;

        Arrays.sort(a);
        Arrays.sort(b);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));


        for (int i = 0; i < a.length; i++) {
            int aSqr =  Math.abs(a[i]) *  Math.abs(a[i]);

            if(Math.abs(b[i]) != aSqr)
                return false;
        }

        return true;

    }
}
