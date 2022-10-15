package _19_palindrome;

public class Palindrome {
    public static void main(String[] args) {
        String str = "abcdcba";
        String str1 = "mum";
//        System.out.println(isPalindrome(str));
//        System.out.println(isPalindrome(str1));
        System.out.println(isPalindromeRecursive(str));
        System.out.println(isPalindromeRecursive(str1));
    }

    private static boolean isPalindromeRecursive(String str) {
        if (str.length() == 1) return true;
        return isPalindromeRecursive(str, 0);
    }

    private static boolean isPalindromeRecursive(String str, int i) {
        int j = str.length() - i - 1;
        if (i >= j)
            return true;
        else
            return String.valueOf(str.charAt(0)).equals(String.valueOf(str.charAt(str.length() - 1))) && isPalindromeRecursive(str, i + 1);
    }

    private static boolean isPalindrome(String str) {
        return false;
    }
}
