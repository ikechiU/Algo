package _22_longest_consecutive;

import java.util.Arrays;
import java.util.Comparator;

public class LongestConsec {

    public static void main(String[] args) {
        System.out.println(longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2));
    }

    public static String longestConsec(String[] strarr, int k) {

        String result = "";
        int count = 0;
        StringBuilder tempResult = new StringBuilder();

        if (k > strarr.length || k <= 0) return "";
        if (k == 1) {
            Arrays.sort(strarr, Comparator.comparingInt(String::length));
            System.out.println(Arrays.toString(strarr));
            return strarr[strarr.length - 1];
        } else {
            for (int i = 0; i < strarr.length; i++) {
                for (int j = i; j < k + i; j++) {
                    if (j <= strarr.length - 1) {
                        tempResult.append(strarr[j]);
                        if (j == k + i - 1) {
                            if(tempResult.length() > count) {
                                count = tempResult.length();
                                result = tempResult.toString();
                            }
                            tempResult = new StringBuilder();
                        }
                    }
                }
            }

        }
        return result;
    }
}
