package _40_generate_document;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ikechi Ucheagwu
 * @created 01/02/2023 - 20:38
 * @project Algo Github
 */

public class GenerateDocument {

    public static void main(String[] args) {
        String string = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";

        System.out.println(solution(string, document));
    }

    private static boolean solution(String string, String document) {
        if (string.length() == 0 && document.length() > 0 || string.length() > 0 && document.length() == 0)
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < document.length(); i++) {
            char ch = document.charAt(i);

            if (map.containsKey(ch)) {
                int value = map.get(ch);
                if (value <= 0) {
                    return false;
                } else {
                    map.put(ch, value - 1);
                }
            } else {
                return false;
            }
        }

        System.out.println(map);
        return true;
    }
}
