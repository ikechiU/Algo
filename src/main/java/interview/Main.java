package interview;

import java.util.*;

/**
 * @author Ikechi Ucheagwu
 * @created 07/01/2023 - 00:32
 * @project AndelaTest
 */
public class Main {

    /* 1
    given an array of distinct integers , determine the minimum absolute difference between any two elements. print all
    element pairs with that difference in ascending order.
    Example
    numbers = [6,2,4,10]
    The minimum absolute difference is 2 and the pairs with that difference are (2,4) and (4,6),
    when printing element pairs (i,j), they should be ordered ascending first by i and they by j.
*/
    public static void printmin(ArrayList<Integer> numbers) {
        // Create a set from the input list to remove duplicates
        Set<Integer> set = new HashSet<>(numbers);
        // Convert the set to a list and sort it
        List<Integer> sortedSet = new ArrayList<>(set);
        Collections.sort(sortedSet);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> values = new ArrayList<>();
        // Find the minimum absolute difference between any two consecutive elements
        // and store the pairs of integers that have this difference
        for (int i = 0; i < sortedSet.size() - 1; i++) {
            int diff = Math.abs(sortedSet.get(i) - sortedSet.get(i + 1));
            if (diff < minDiff) {
                minDiff = diff;
                values.clear();
                values.add(Arrays.asList(sortedSet.get(i), sortedSet.get(i + 1)));
            } else if (diff == minDiff) {
                values.add(Arrays.asList(sortedSet.get(i), sortedSet.get(i + 1)));
            }
        }
        // Print the pairs of integers that have the minimum absolute difference
        for (List<Integer> pair : values) {
            System.out.println(pair.get(0) + " " + pair.get(1));
        }
    }
    /* 2
        A triangle formed by the three point a(x1,y1), b(x2,y2) and c(x3,y3) is a non-degenerated triangle
        if the following rules are respected (/ab/ is the length of the line between points a and b);
        |ab| + |bc| > |ac|
        |bc| + |ac| > |ab|
        |ab| + |ac| > |bc|
        A point belongs to a triangle if it lies somewhere on or inside the triangle. Given two points
        p = (xp, yp) and q = (xq, yq), return the correct scenario number:
        - 0 : if the triangle abc does not form a valid non- degenerated triangle
        - 1 : if point p belongs to the triangle but point q does not.
        - 2 : if point q belongs to the triangle but point p does not.
        - 3 : if both p and q belong to the triangle.
        - 4 : if neither point p nor point q belong to the triangle
     */
    public static int tri(int x1, int y1, int x2, int y2, int x3, int y3, int xp, int yp, int xq, int yq) {
        double ab, bc, ac, area, p1, p2, p3, q1, q2, q3;
        ab = Math.sqrt( Math.pow(Math.abs(x1 - x2),2)+ Math.pow(Math.abs(y1 - y2),2));
        bc = Math.sqrt( Math.pow(Math.abs(x2 - x3), 2) + Math.pow(Math.abs(y2 - y3), 2));
        ac = Math.sqrt( Math.pow(Math.abs(x1 - x3), 2) + Math.pow(Math.abs(y1 - y3), 2));
        area= Math.abs(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))/2.0 ;

        p1= Math.abs ( xp*(y2-y3) + x2*(y3-yp) + x3*(yp-y2) )/2.0;

        p2= Math.abs ( x1*(yp-y3) + xp*(y3-y1) + x3*(y1-yp) )/2.0;

        p3= Math.abs ( x1*(y2-yp) + x2*(yp-y1) + xp*(y1-y2) )/2.0;

        q1= Math.abs ( xq*(y2-y3) + x2*(y3-yq) + x3*(yq-y2) )/2.0;
        q2= Math.abs ( x1*(yq-y3) + xq*(y3-y1) + x3*(y1-yq) )/2.0;
        q3= Math.abs ( x1*(y2-yq) + x2*(yq-y1) + xq*(y1-y2) )/2.0;
        boolean p, q, pq, non, nottri;
        p= p1+p2+p3==area && !(q1+q2+q3==area);
        q= !(p1+p2+p3==area) && (q1+q2+q3==area);
        pq= p1+p2+p3==area && q1+q2+q3==area;
        non= !(p1+p2+p3==area) && !(q1+q2+q3==area);
        nottri = (ab + bc) > ac && (bc + ac) > ab && (ab + ac) > bc;
        if (!nottri) {
            return 0;
        }
        else if (p) {
            return 1;
        }
        else if (q) {
            return 2;
        }
        else if (pq) {
            return 3;
        }
        else if (non) {
            return 4;
        }
        return 9;
    }
    /* 3
        A function receives a string s amd a series of queries. for each query, there will be a beginning and
        ending index and number of substitutions. A palindrome is a string spelled the same way forward or backward, like a,
        mom or abba. for each substring represented by the beginning and ending index of the string s, determine if it
        is possible to rearrange it to a palindrome after performing up to the given number of substitutions.
        start with an empty result string. After each query, append a 1 or 0 to indicate whether the substring can be
         converted to a palindrome. A 1 represents yes and a 0 represents no. return the results string after all queries
         have been processed.
         Example
         s = cdecd
         startIndex = [0,0,0,0]
         endindex = [0,1,2,3]
         subs = [0,1,1,0]
     */
    public static String isPil(String s, List<Integer> startIndex, List<Integer> endIndex, List<Integer> subs) {
        String ans = "";
        for (int i = 0; i < startIndex.size(); i++) {
            String word = s.substring(startIndex.get(i), endIndex.get(i) + 1).toLowerCase();
            int numOddCountChars = numOddCountChars(word);
            boolean isPalindrome;
            if (word.length() < 4) {
                isPalindrome = word.length() == 1 || subs.get(i) >= numOddCountChars / 2;
            } else {
                isPalindrome = subs.get(i) >= numOddCountChars / 2;
            }
            ans += isPalindrome ? "1" : "0";
        }
        return ans;
    }
    private static int numOddCountChars(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        return (int) charCounts.values().stream().filter(v -> v % 2 != 0).count();
    }

}
