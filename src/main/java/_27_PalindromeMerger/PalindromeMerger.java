//package _27_PalindromeMerger;
//
//import java.util.*;
//
///**
// * @author Ikechi Ucheagwu
// * @created 14/01/2023 - 8:35 PM
// * @project AlgoInterview
// */
//
//public class PalindromeMerger {
//
//    public static void main(String[] args) {
//        //[abcba, bacab]
//        //[defqfed, dfeqefd, edfqfde efdqdfe, fdeqedf, fedqdef]
//
//        String resultA = findFirstPalindrome("aabbc");
//        String resultB = findFirstPalindrome("ddefefq");
//
//        String resultA1 = findFirstPalindrome("aabb");
//        String resultB1 = findFirstPalindrome("ddefefq");
//
//        String resultA2 = findFirstPalindrome("aabbc");
//        String resultB2 = findFirstPalindrome("ddefef");
//
//        String resultA3 = findFirstPalindrome("aabb");
//        String resultB3 = findFirstPalindrome("ddefef");
//
//        mergePalindromes(resultA, resultB);
//        mergePalindromes(resultA1, resultB1);
//        mergePalindromes(resultA2, resultB2);
//        mergePalindromes(resultA3, resultB3);
//
//    }
//
//    public static String mergePalindromes(String s1, String s2) {
//        String p1 = findFirstPalindrome(s1);
//        String p2 = findFirstPalindrome(s2);
//
//        System.out.println(p1);
//        System.out.println(p2);
//
//        int p1rem = p1.length() % 2;
//        int p2rem = p2.length() % 2;
//        int p1Half = p1.length() / 2;
//        int p2Half = p2.length() / 2;
//
//
//        String sP1Half = p1.substring(0, p1Half);
//        String sP2Half = p2.substring(0, p2Half);
//
//        System.out.println(sP1Half);
//        System.out.println(sP2Half);
//
//        String s1Middle = "";
//        if (p1rem != 0) {
//            s1Middle = p1.substring(p1Half, p1Half + 1);
//        }
//
//        String s2Middle = "";
//        if (p2rem != 0) {
//            s2Middle = p2.substring(p2Half, p2Half + 1);
//        }
//
//        System.out.println("Middle 1: " + s1Middle);
//        System.out.println("Middle 2: " + s2Middle);
//
//        String combined  = sP1Half + sP2Half;
//        char[] chars = combined.toCharArray();
//        Arrays.sort(chars);
//        System.out.println("Characters sorted: " + Arrays.toString(chars));
//        String combinedSorted = String.valueOf(chars);
//        System.out.println("String value of sorted: " +combinedSorted);
//        String reversedCombined = new StringBuilder(combinedSorted).reverse().toString();
//        System.out.println("String value of sorted reversed: " +reversedCombined);
//
//        String strMiddle = "";
//        if (s1Middle.isEmpty() && s2Middle.isEmpty()) {
//            strMiddle = "";
//        } else if (!s1Middle.isEmpty() && s2Middle.isEmpty()) {
//            strMiddle = s1Middle;
//        } else if (!s2.isEmpty() && s1Middle.isEmpty()) {
//            strMiddle = s2Middle;
//        } else if (!s1Middle.isEmpty() && !s2Middle){
//
//            if () strMiddle  = s1Middle;
//        }
//
//        return "";
//
//    }
//
//    public static String findFirstPalindrome(String s) {
//        Set<String> palindromes = findAllPalindromes(s);
//        System.out.println(palindromes);
//        List<String> palindromesList = new ArrayList<>(palindromes);
//        Collections.sort(palindromesList);
//        return palindromesList.get(0);
//    }
//
//    public static Set<String> findAllPalindromes(String s) {
//        Set<String> palindromes = new HashSet<>();
//        generatePalindrome(palindromes, "", s);
//        return palindromes;
//    }
//
//    private static void generatePalindrome(Set<String> palindromes, String current, String remaining) {
//        if (remaining.length() == 0) {
//            if (isPalindrome(current)) {
//                palindromes.add(current);
//            }
//            return;
//        }
//
//        for (int i = 0; i < remaining.length(); i++) {
//            String next = current + remaining.charAt(i);
//            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
//            generatePalindrome(palindromes, next, newRemaining);
//        }
//    }
//
//    private static boolean isPalindrome(String s) {
//        // Check if a string is a palindrome
//        int i = 0;
//        int j = s.length() - 1;
//        while (i < j) {
//            if (s.charAt(i) != s.charAt(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
//
//
//    public static List<String> findAllPalindromes2(String s) {
//        List<String> palindromes = new ArrayList<>();
//        char[] t = preprocess(s).toCharArray();
//        int n = t.length;
//        int[] p = new int[n];
//        int c = 0, r = 0;
//        for (int i = 1; i < n - 1; i++) {
//            int i_mirror = 2 * c - i;
//            if (r > i) {
//                p[i] = Math.min(r - i, p[i_mirror]);
//            } else {
//                p[i] = 0;
//            }
//            while (t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
//                p[i]++;
//            }
//            if (i + p[i] > r) {
//                c = i;
//                r = i + p[i];
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (t[i] != '#') {
//                int len = (p[i] + 1) / 2;
//                int start = (i - p[i]) / 2;
//                palindromes.add(s.substring(start, start + len));
//            }
//        }
//        return palindromes;
//    }
//
//    private static String preprocess(String s) {
//        int n = s.length();
//        if (n == 0) {
//            return "^$";
//        }
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("^");
//        for (int i = 0; i < n; i++) {
//            sb.append("#").append(s.charAt(i));
//        }
//        sb.append("#$");
//        return sb.toString();
//    }
//
//    public static String findLargestPalindrome(String s) {
//        String longest = "";
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                String sub = s.substring(i, j);
//                if (sub.length() > longest.length() && isPalindromes(sub)) {
//                    longest = sub;
//                }
//            }
//        }
//        return longest;
//    }
//
//    private static boolean isPalindromes(String s) {
//        int left = 0;
//        int right = s.length() - 1;
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
//
//
//}
