package interview;

/**
 * @author Ikechi Ucheagwu
 * @created 31/01/2023 - 16:24
 * @project Algo Github
 */

public class Others4 {

    public static void main(String[] args) {
        String[] strs = {"reflower","reflower","flight"};
        String[] strs2 = {"flow", "flowers", "flight"};
        String[] strs3 = {"dog","cat","cow"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(strs3));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
