package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ikechi Ucheagwu
 * @created 03/02/2023 - 02:38
 * @project Algo Github
 */

class Four {
    public static void main(String[] args) {
        String s = "abacbc";
        String t = "bca";

        int min = Math.max(10, 9) + 7;
        for(int i = 0; i < t.length(); i++){
            if(!s.contains(Character.toString(t.charAt(i)))){
                System.out.println("min: " + 0);
                //return 0;
            }
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),  1);
            }
            else{
                map.replace(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }

        for(Map.Entry<Character,Integer> e : map.entrySet()){
            if(t.contains(Character.toString(e.getKey()))){
                min = Math.min(min, e.getValue());
            }
        }
        System.out.println("min " + min);
        //return min;
    }
}