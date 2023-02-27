package z_others;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Brackets {


//    public static void main(String[] args) {
////        a("{([])}]]");
//        a("(())");
//    }

    public static void main(String[] args) {
        String brackets = "{[()[]]()}()";
        String brackets2 = "{[()[]]()}()";

//        System.out.println(isValidBrackets(brackets));
//        System.out.println(isValidBrackets(brackets2));
//        System.out.println(isValidBrackets("{}{{}}{{{}}}{{{{}}}}{}{}{}"));
//
//        System.out.println(isValidBrackets2(brackets));
//        System.out.println(isValidBrackets2(brackets2));
//        System.out.println(isValidBrackets2("{}{{}}{{{}}}{{{{}}}}{}{}{}"));

        System.out.println(methodThree(brackets));
        System.out.println(methodThree(brackets2));
        System.out.println(methodThree("{}{{}}{{{}}}{{{{}}}}{}{}{}"));
    }

    private static String methodOne(String brackets) {

        if (brackets.length() % 2 != 0)
            return "invalid";
        else {
            for (int i = 0; i < brackets.length(); i++) {
                var character = brackets.charAt(i);

                if (!(character == '(' || character == '[' || character == '{' ||
                        character == ')' || character == ']' || character == '}')) {
                    return "invalid";
                }
            }
        }

        while (brackets.contains("()") || brackets.contains("{}") || brackets.contains("[]")) {
            brackets = brackets.replaceAll("\\(\\)", "")
                    .replaceAll("\\{\\}", "")
                    .replaceAll("\\[\\]", "");
        }

        if (brackets.length() == 0)
            return "invalid";
        else
            return "valid";
    }

    private static String methodTwo(String brackets) {
        Deque<Character> deque = new LinkedList<Character>();

        for (char ch : brackets.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                deque.addFirst(ch);
            } else {
                if (!deque.isEmpty()
                        && ((deque.peekFirst() == '[' && ch == ']') ||
                        (deque.peekFirst() == '{' && ch == '}') ||
                        (deque.peekFirst() == '(' && ch == ')'))
                ) {
                    deque.removeFirst();
                }
            }
        }

        if (brackets.length() == 0)
            return "invalid";
        else
            return "valid";
    }

    private static String methodThree(String brackets) {
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < brackets.length(); i++) {
            char ch = brackets.charAt(i);

            if (ch == '[' || ch == '{' || ch == '(') {
                deque.push(ch);
            } else {
                if (deque.isEmpty()) {
                    return "invalid";
                } else {
                    char check;
                    switch (ch) {
                        case ']':
                            check = deque.pop();
                            if (check == '{' || check == '(')
                                return "invalid";
                            break;
                        case '}':
                            check = deque.pop();
                            if (check == '[' || check == '(')
                                return "invalid";
                            break;
                        case ')':
                            check = deque.pop();
                            if (check == '{' || check == '[')
                                return "invalid";
                            break;
                    }
                }
            }
        }

        if (brackets.length() == 0)
            return "invalid";
        else
            return "valid";
    }

    public static String a(String bracket) {
        Character[] arr = new Character[bracket.length()];

        for (int i = 0; i < bracket.length(); i++) {
            arr[i] = bracket.charAt(i);
        }
        System.out.println("Before sorting" + Arrays.toString(arr));

//        Arrays.sort(arr, );

        System.out.println("After sorting" + Arrays.toString(arr));

        String returnValue = "";
        boolean isValid = true;

        while (isValid) {
            for (int i = 0; i < arr.length; i+=2) {
                var ch = arr[i];
                var chj = arr[i + 1];

                if (ch == ')' || ch == ']' || ch == '}') {
                    returnValue = "invalid";
                    isValid = false;
                    break;
                }

                if (ch == '(' && chj != ')' || ch == '[' && chj != ']' || ch == '{' && chj != '}') {
                    returnValue = "invalid";
                    isValid = false;
                    break;
                } else {
                    returnValue = "valid";
                }
            }
        }


        return returnValue;
    }
}
