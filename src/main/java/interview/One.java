package interview;

/**
 * @author Ikechi Ucheagwu
 * @created 01/02/2023 - 13:37
 * @project Algo Github
 */

public class One {
    public static void main(String[] args) {

        System.out.println(solution2("abcdcba"));
        System.out.println(solution2("abcdeedcba"));
        System.out.println(solution2("abcdefedcba"));
        System.out.println(solution2("abcdefdcba"));
    }

    private static boolean solution(String str) {
        int leftPointer = 0;
        int rightPointer = str.length() - 1;

        while (leftPointer < rightPointer) {
            if (str.charAt(leftPointer) == str.charAt(rightPointer)) {
                leftPointer++;
                rightPointer--;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean solution2(String str) {
        return recursive(str, 0);
    }

    private static boolean recursive(String str, int i) {
        int j = str.length() - i - 1;
        if (i >= j) {
            return true;
        }
        return str.charAt(i) == str.charAt(j) && recursive(str, i + 1);
    }

}
