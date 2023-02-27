package z_others;

import java.util.HashMap;

public class MorseCode {

    private static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {

        map.put("-.-.--", "!");
        map.put(".-..-.", "\"");
        map.put("...-..-", "$");
        map.put(".-...", "&");
        map.put(".----.", "'");
        map.put("-.--.", "(");
        map.put("-.--.-", ")");
        map.put(".-.-.", "+");
        map.put("--..--", ",");
        map.put("-....-", "-");
        map.put(".-.-.-", ".");
        map.put("-..-.", "/");
        map.put("-----", "0");
        map.put(".----", "1");
        map.put("..---", "2");
        map.put("...--", "3");
        map.put("....-", "4");
        map.put(".....", "5");
        map.put("-....", "6");
        map.put("--...", "7");
        map.put("---..", "8");
        map.put("----.", "9");
        map.put("---...", ":");
        map.put("-.-.-.", ";");
        map.put("-...-", "=");
        map.put("..--..", "?");
        map.put(".--.-.", "@");
        map.put(".-", "A");
        map.put("-...", "B");
        map.put("-.-.", "C");
        map.put("-..", "D");
        map.put(".", "E");
        map.put("..-.", "F");
        map.put("--.", "G");
        map.put("....", "H");
        map.put("..", "I");
        map.put(".---", "J");
        map.put("-.-", "K");
        map.put(".-..", "L");
        map.put("--", "M");
        map.put("-.", "N");
        map.put("---", "O");
        map.put(".--.", "P");
        map.put("--.-", "Q");
        map.put(".-.", "R");
        map.put("...", "S");
        map.put("-", "T");
        map.put("..-", "U");
        map.put("...-", "V");
        map.put(".--", "W");
        map.put("-..-", "X");
        map.put("-.--", "Y");
        map.put("--..", "Z");
        map.put("..--.-", "_");
        map.put("...---...", "SOS");

        String morse1 = "";
        String morse2 = "";


        System.out.println(decodeMorse(map, morse1));
        System.out.println(decodeMorse(map, morse2));
    }

    private static String decodeMorse(HashMap<String, String> map, String morse) {
        String trimmedMorse = morse.trim();
        String returnValue = "";

        return returnValue;
    }
}
