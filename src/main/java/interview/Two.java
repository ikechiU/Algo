package interview;

/**
 * @author Ikechi Ucheagwu
 * @created 01/02/2023 - 15:03
 * @project Algo Github
 */

public class Two {
    public static void main(String[] args) {

        //runUnicodeCharacter();
        String a = "Hello";
        System.out.println(a + " " + a.hashCode());

        a = "Happy";
        System.out.println(a + " " + a.hashCode());


    }

    private static void runUnicodeCharacter() {
        char[] charsUpperCase = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] charsLowerCase = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for(char c : charsUpperCase) {
            System.out.print((int) c + " ");
        }
        System.out.println();
        for(char c : charsUpperCase) {
            System.out.print(Character.valueOf((char) (int) c));
        }
        System.out.println();
        for(char c : charsLowerCase) {
            System.out.print((int) c + " ");
        }
        System.out.println();
        for(char c : charsLowerCase) {
            System.out.print(Character.valueOf((char) (int) c));
        }
    }
}
