package interview;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Ikechi Ucheagwu
 * @created 08/02/2023 - 09:37
 * @project Algo Github
 */

public class Six {

    public static void main(String[] args) {

        String one = "ACCAABBC";
        String two = "ABCBBCBA";
        String three = "BABABA";

        System.out.println(solution(one));
        System.out.println(solution(two));
        System.out.println(solution(three));

        System.out.println(efficientMethod(one));
        System.out.println(efficientMethod(two));
        System.out.println(efficientMethod(three));

    }

    private static String solution(String str) {
        while (str.contains("AA") || str.contains("BB") || str.contains("CC")) {
            str = str.replaceAll("AA", "")
                    .replaceAll("BB", "")
                    .replaceAll("CC", "");
        }
        return str;
    }

    private static String efficientMethod(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (!stack.isEmpty() && str.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.add(str.charAt(i));
            }
        }

//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()) {
//            sb.append(stack.pop());
//        }
//        return sb.reverse().toString();

        String[] strings = stack.stream().map(character -> Character.toString(character)).toArray(String[]::new);
        return String.join("", strings);
    }

}
