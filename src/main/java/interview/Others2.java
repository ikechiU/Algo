package interview;

import java.util.*;

/**
 * @author Ikechi Ucheagwu
 * @created 30/01/2023 - 23:09
 * @project Algo Github
 */

public class Others2 {


    public static void main(String[] args) {
        String[] commands = {
                "goto bucketA",
                "create fileA",
                "create fileB",
                "create fileA",
                "goto bucketB",
                "goto bucketC",
                "create fileA",
                "create fileB",
                "create fileC",
        };
        var a = solution(commands);
        System.out.println(a);
    }

    private static String solution(String[] commands) {
        Map<String, HashSet<String>> buckets = new HashMap<>();

        String presentGoto = "";

        for (String string : commands) {
            if (string.charAt(0) == 'g') {
                presentGoto = string.substring(5);
            } else {
                if (string.charAt(0) == 'c') {
                    if (buckets.containsKey(presentGoto)) {
                        HashSet<String> strings = buckets.get(presentGoto);
                        strings.add(string);
                        buckets.put(presentGoto, strings);
                    } else {
                        buckets.put(presentGoto, new HashSet<>(Collections.singleton(string)));
                    }
                }
            }
        }

        int size = Integer.MIN_VALUE;
        String result = "";

        Set<String> strings = buckets.keySet();
        for(String string : strings) {
            HashSet<String> hashSet = buckets.get(string);
            if (hashSet.size() > size) {
                result = string;
                size = hashSet.size();
            }
        }

        System.out.println(size);
        return result;
    }
}
