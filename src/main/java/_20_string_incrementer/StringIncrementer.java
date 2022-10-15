package _20_string_incrementer;

import java.util.ArrayList;
import java.util.Arrays;

public class StringIncrementer {
    public static void main(String[] args) {
        //Check test cases in test package
    }

    public String stringIncrementer(String str) {
        if (str.isEmpty()) return "1";
        if(!Character.isDigit(str.charAt(str.length() - 1))) return str + "1";

        int lastDigitPosition = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                break;
            }
            lastDigitPosition = i;
        }

        String firstPart = str.substring(0, lastDigitPosition);
        String lastPart = str.substring(lastDigitPosition);
        String[] lastPartArr = lastPart.split("");

        ArrayList<String> lastPartList = new ArrayList<>(Arrays.asList(lastPartArr));

        for (int i = lastPartList.size() - 1; i >= 0; i--) {
            int ele = Integer.parseInt(lastPartList.get(i)) + 1;

            if (ele == 10) {
                lastPartList.set(i, "0");
                if (i == 0) {
                    lastPartList.add(0, "1");
                }
            } else {
                lastPartList.set(i, String.valueOf(ele));
                break;
            }
        }

        return firstPart + String.join("", lastPartList);
    }
}
