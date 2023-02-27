package z_others;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {

    public static void main(String[] args) {
//        System.out.println(romanToDecimal("MDXC"));
//        System.out.println(romanToDecimal("MMCDXLVIII"));
//        System.out.println(romanToDecimal("MMMDCCXXIV"));
//        System.out.println(romanToDecimal("MMMCMXCIX"));
//
//        System.out.println(decimalToRoman(1590));
//        System.out.println(decimalToRoman(2448));
//        System.out.println(decimalToRoman(3724));
//        System.out.println(decimalToRoman(3999));
        System.out.println(romanToDecimal2("MMMCMXCIX"));
        System.out.println(decimalToRoman2(romanToDecimal2("MMMCMXCIX")));
    }

    private static String decimalToRoman2(int number) {
        String[] romanNumeralsKey = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] romanNumeralsValue = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder stringBuilder = new StringBuilder();
        var num = number;

        for (int i = 0; i < romanNumeralsKey.length; i++) {
            if (num >= romanNumeralsValue[i]) {
                num -= romanNumeralsValue[i];
                stringBuilder.append(romanNumeralsKey[i]);
                i--;
            }
        }

        return new String(stringBuilder);
    }

    private static String decimalToRoman(int number) {
        String[] romanNumeralsKey = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] romanNumeralsValue = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder stringBuilder = new StringBuilder();
        var num = number;

        while (num != 0) {
            for (int i = 0; i < romanNumeralsKey.length; i++) {
                if (num >= romanNumeralsValue[i]) {
                    num -= romanNumeralsValue[i];
                    stringBuilder.append(romanNumeralsKey[i]);
                    i--;
                }
            }
        }

        return new String(stringBuilder);
    }

    private static int romanToDecimal(String romanNumeral) {
        var count = 0;

        for (int i = 0; i < romanNumeral.length(); i++) {
            var ch = romanNumeral.charAt(i);
            var nextPosition = i + 1;
            char chNext;

            if (ch == 'M')
                count += 1000;

            if (ch == 'D')
                count += 500;

            if (ch == 'L')
                count += 50;

            if (ch == 'V')
                count += 5;

            if (ch == 'C') {
                if (i != romanNumeral.length() - 1) {
                    chNext = romanNumeral.charAt(nextPosition);

                    if (chNext == 'M') {
                        count += 900;
                        i = nextPosition;
                    } else if (chNext == 'D') {
                        count += 400;
                        i = nextPosition;
                    } else {
                        count += 100;
                    }
                } else {
                    count += 100;
                }
            }

            if (ch == 'X') {
                if (i != romanNumeral.length() - 1) {
                    chNext = romanNumeral.charAt(nextPosition);

                    if (chNext == 'C') {
                        count += 90;
                        i = nextPosition;
                    } else if (chNext == 'L') {
                        count += 40;
                        i = nextPosition;
                    } else {
                        count += 10;
                    }
                } else {
                    count += 10;
                }
            }

            if (ch == 'I') {
                if (i != romanNumeral.length() - 1) {
                    chNext = romanNumeral.charAt(nextPosition);

                    if (chNext == 'X') {
                        count += 9;
                        i = nextPosition;
                    } else if (chNext == 'V') {
                        count += 4;
                        i = nextPosition;
                    } else {
                        count += 1;
                    }
                } else {
                    count += 1;
                }
            }
        }

        return count;
    }

    private static int romanToDecimal2(String romanNumeral) {

        Map<Character, Integer> translations = new HashMap<>();
        translations.put('I', 1);
        translations.put('V', 5);
        translations.put('X', 10);
        translations.put('L', 50);
        translations.put('C', 100);
        translations.put('D', 500);
        translations.put('M', 1000);

        while (romanNumeral.contains("IV") || romanNumeral.contains("XL") || romanNumeral.contains("CD") ||
                romanNumeral.contains("IX") || romanNumeral.contains("XC") || romanNumeral.contains("CM")) {

            romanNumeral = romanNumeral.replaceAll("IV", "IIII")
                    .replaceAll("XL", "XXXX")
                    .replaceAll("CD", "CCCC")
                    .replaceAll("IX", "VIIII")
                    .replaceAll("XC", "LXXXX")
                    .replaceAll("CM", "DCCCC");
        }

        var number = 0;
        for (int i = 0; i < romanNumeral.length(); i++) {
            char ch = romanNumeral.charAt(i);
            number += translations.get(ch);
        }

        return number;
    }

}
