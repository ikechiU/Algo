package org.example._10_break_camel_case;

public class BreakCamelCase {

    public static void main(String[] args) {
        System.out.println(camelCase("camelCasing"));
        System.out.println(camelCase("identifier"));
        System.out.println(camelCase(""));
    }

    public static String camelCase(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            String str = String.valueOf(input.charAt(i));
            String strLowerCase = String.valueOf(input.charAt(i)).toLowerCase();

            if(str.equals(strLowerCase)) sb.append(str);
            else sb.append(" ").append(str);
        }

        return sb.toString();
    }
}
