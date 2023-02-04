package _48_longest_palindrome;

/**
 * @author Ikechi Ucheagwu
 * @created 03/02/2023 - 10:03
 * @project Algo Github
 */

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcdcbafglkgf"));
        System.out.println(longestPalindrome("asdfghjklkjhgfdsa"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
