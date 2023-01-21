package _19_palindrome;

public class Palindrome {
    public static void main(String[] args) {
        String str = "abcdcba";
        String str1 = "mum";
        String str2 = "mumualgo";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome(str1));
        System.out.println(isPalindrome(str2));
        System.out.println(isPalindromeRecursive(str));
        System.out.println(isPalindromeRecursive(str1));
        System.out.println(isPalindromeRecursive(str2));
    }

    private static boolean isPalindromeRecursive(String str) {
        if (str.length() == 1) return true;
        return isPalindromeRecursive(str, 0);
    }

    // TC -> O(N) | SC -> O(N)
    private static boolean isPalindromeRecursive(String str, int i) {
        int j = str.length() - i - 1;
        if (i >= j)
            return true;
        else
            return str.charAt(i) == str.charAt(j) && isPalindromeRecursive(str, i + 1);
    }

    // TC -> O(N) | SC -> O(1)
    private static boolean isPalindrome(String str) {
        int leftIdx = 0;
        int rightIdx = str.length() - 1;

        while (leftIdx < rightIdx) {
            if (str.charAt(leftIdx) == str.charAt(rightIdx)) {
                leftIdx++;
                rightIdx--;
            } else {
                return false;
            }
        }

        return true;
    }
}
