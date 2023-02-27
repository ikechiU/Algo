package z_others;

import java.util.Arrays;
import java.util.Collections;

public class Kata {

    public static void main(String[] args) {
        String s1 = reverseWords("This is an example!");
        String s2 = reverseWords("double  spaces");
    }

    public static String reverseWords(final String original) {
        // Have at it
        String returnValue = "";
        String[] strArr = original.split(" ", 0);

        Collections.reverse(Arrays.asList(strArr));
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : strArr) {
            stringBuilder.append(s).append(" ");
        }

        System.out.println(stringBuilder);

        return returnValue;
    }
}