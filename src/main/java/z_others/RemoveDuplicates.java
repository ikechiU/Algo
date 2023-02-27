package z_others;

import java.util.HashMap;

public class RemoveDuplicates {

    private static HashMap<String, String[]> map = new HashMap<>();
    private static HashMap<String, String[]> map2 = new HashMap<>();

    public static void main(String[] args) {

        map.put("1", new String[]{"A", "B", "C"});
        map.put("2", new String[]{"A", "B", "D", "A"});

        map2.put("1", new String[]{"C", "F", "G"});
        map2.put("2", new String[]{"A", "B", "C"});
        map2.put("3", new String[]{"A", "B", "D"});

        System.out.println(removeDuplicates(map));
        System.out.println(removeDuplicates(map2));
    }

    private static HashMap<String, String[]> removeDuplicates(HashMap<String, String[]> map) {

        HashMap<String, String[]> newMap = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        for (HashMap.Entry<String, String[]> pair : map.entrySet()) {
            var pairValue = pair.getValue();

            for (String ele : pairValue) {
                builder.append(ele);
            }
            builder.append(" ");
        }

        var s = new String(builder).trim().split(" ");

        for (int i = 0; i < s.length; i++) {
            var str = s[i];


        }





        return newMap;
    }

}
