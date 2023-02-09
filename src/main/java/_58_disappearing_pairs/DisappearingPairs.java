package _58_disappearing_pairs;

import java.util.Stack;

/**
 * @author Ikechi Ucheagwu
 * @created 08/02/2023 - 15:13
 * @project Algo Github
 */

/*
* A string S containing only the letters "A", "B" and "C" is given. The string can be transformed by removing one occurrence of "AA", "BB" or "CC".

Transformation of the string is the process of removing letters from it, based on the rules described above. As long as at least one rule can be applied, the process should be repeated. If more than one rule can be used, any one of them could be chosen.

Write a function:

class Solution { public String solution(String S); }

that, given a string S consisting of N characters, returns any string that can result from a sequence of transformations as described above.

For example, given string S = "ACCAABBC" the function may return "AC", because one of the possible sequences of transformations is as follows:



Also, given string S = "ABCBBCBA" the function may return "", because one possible sequence of transformations is:



Finally, for string S = "BABABA" the function must return "BABABA", because no rules can be applied to string S.

Write an efficient algorithm for the following assumptions:

the length of string S is within the range [0..50,000];
string S is made only of the following characters: "A", "B" and/or "C".*/

public class DisappearingPairs {

    public static void main(String[] args) {

        String str1 = "ACCAABBC";
        String str2 = "ABCBBCBA";
        String str3 = "BABABA";

        System.out.println(solution(str1));
        System.out.println(solution(str2));
        System.out.println(solution(str3));
    }

    public static String solution(String str) { //TC = O(N)
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (!stack.isEmpty() && (stack.peek() == c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static String inEfficientMethod(String str) { //TC = O(N^2)
        while (str.contains("AA") || str.contains("BB") || str.contains("CC")) {
            str = str.replaceAll("AA", "")
                    .replaceAll("BB", "")
                    .replaceAll("CC", "");
        }
        return str;
    }


}
