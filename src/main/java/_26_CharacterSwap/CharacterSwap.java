package _26_CharacterSwap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ikechi Ucheagwu
 * @created 15/01/2023 - 16:01
 * @project Algo Github
 */

/*
*
1. Characters Swap

Given a string s, repeat this operation zero or more times to create the lexicographically smallest string possible.


1. Select two characters that exist in the string, c1, and c2.

2. Replace all occurrences of c1 with c2 and all Occurrences of c2 with c1.

Note: For two strings x and y of length n x Is lexicographically smaller than y if the first non-matching character
in x is less than the character at that position in y.


Example

s = "bbcacad"

Select c1 = 'b' and c2 = 'a',  after swapping occurrences, s = 'aacbcbd'
Select c1 = 'b' and c2 = 'c',  after swapping occurrences of c1 and c2 we get s = "aabcbcd"

It can be proven that this is the lexicographically smallest string s can be converted to. Return "aabcbcd".

Function Description
Complete the function getString in the editor below.

getString has the following parameter:
string s: the string to process

Returns
string s can be changed to.*/

public class CharacterSwap {

    public static String getString(String s) {
        List<Character> characters = new ArrayList<>();
        String returnValue = s;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!characters.contains(ch)) {
                characters.add(ch);
            }
        }

        for (int i = 0; i < characters.size() - 1; i++) {
            Character one = characters.get(i);
            Character two = characters.get(i + 1);

            if (one > two) {
                for (int j = 0; j < characters.size(); j++) {
                    var eleJ = characters.get(j);
                    if (eleJ.equals(one)) {
                        characters.set(j, two);
                    } else if (eleJ.equals(two)) {
                        characters.set(j, one);
                    }
                }
                returnValue = swap(one, two, returnValue);
                i = -1;
            }
        }

        return returnValue;
    }

    private static String swap(Character one, Character two, String returnValue) {
        StringBuilder sb = new StringBuilder();

        String strOne = String.valueOf(one);
        String strTwo = String.valueOf(two);

        for (int i = 0; i < returnValue.length(); i++) {
            String eleI = String.valueOf(returnValue.charAt(i));

            if (eleI.equals(strOne)) {
                sb.append(strTwo);
            } else if (eleI.equals(strTwo)) {
                sb.append(strOne);
            } else {
                sb.append(eleI);
            }
        }

        return sb.toString();
    }



    public static void main(String[] args) {
        String s = "bbcacad";
        String s1 = "bbcaacd";
        String s2 = "bbcaacggdsdjsajashddahgadsjgdasgjadsgdsjgzsdd";
        System.out.println(getString(s)); // Output: "aabcbcd"
        System.out.println(getString(s1)); // Output: "aabccbd"
        System.out.println(getString(s2)); // Output: "bbcaacggdsdjsajashddahgadsjgdasgjadsgdsjgzsdd"
    }

}
