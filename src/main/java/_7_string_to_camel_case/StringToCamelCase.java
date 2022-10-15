package _7_string_to_camel_case;

public class StringToCamelCase {

    public static void main(String[] args) {
        System.out.println(toCamelCase("the-stealth-warrior"));
        System.out.println(toCamelCase("The_Stealth_Warrior"));
    }

    static String toCamelCase(String s){
        StringBuilder sb = new StringBuilder();
        boolean isDash = false;

        for (int i = 0; i < s.length(); i++) {
            char ele = s.charAt(i);

            if (ele == '-' || ele == '_') {
                isDash = true;
                continue;
            }

            if(isDash) {
                sb.append(String.valueOf(ele).toUpperCase());
                isDash = false;
            } else {
                sb.append(ele);
            }
        }

        return sb.toString();
    }
}
