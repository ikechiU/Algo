package interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ikechi Ucheagwu
 * @created 31/01/2023 - 09:46
 * @project Algo Github
 */

public class Others3 {

    public static void main(String[] args) {
        var a  = Arrays.asList(3, 2, 1);
        Collections.sort(a.subList(0, 2));
        System.out.println(a);

        var b = new int[]{3, 2, 1};

        Arrays.sort(b, 0, 2);
        System.out.println(Arrays.toString(b));

        var c = "IXVC";
        String replace = c.replace("ID", "");
        System.out.println(replace);

        String[] strs = {"flower","flow","flight"};
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(strs));

        String[] strs1 = {"reflower","reflower","flight"};
        String[] strs2 = {"flow", "flowers", "flight"};
        String[] strs3 = {"dog","cat","cow"};
        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(strs3));
    }

    private static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.equals("")) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
