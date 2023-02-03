package _41_first_non_reapeating_character;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ikechi Ucheagwu
 * @created 01/02/2023 - 23:43
 * @project Algo Github
 */

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String str = "adbfacdcf";
        System.out.println(solution(str));
    }

    private static int solution(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.get(ch) == 1) return i;
        }

        return -1;
    }
}
