package _38_ceaser_cipher_encryptor;

/**
 * @author Ikechi Ucheagwu
 * @created 01/02/2023 - 15:17
 * @project Algo Github
 */

public class CaeserCipherEncryptor {

    public static void main(String[] args) {
        /*
        * 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90
        * ABCDEFGHIJKLMNOPQRSTUVWXYZ
        * 97 98 99 100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115 116 117 118 119 120 121 122
        * abcdefghijklmnopqrstuvwxyz
        */

        String str = "xyz"; // -> zab
//        String str = "XYZ"; // -> ZAB
//        String str = "XyZ"; // -> ZaB
//        String str = "xYz"; // -> zAb
        int key = 54 % 26;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String ele = String.valueOf(str.charAt(i)).toLowerCase();
            int value = str.charAt(i) + key;

            if (ele.charAt(0) == str.charAt(i)) {//lowercase 97 - 122
                if (value > 122) {
                    value = 96 + ((value - 122) % 26);
                    System.out.println(value);
                }
            } else {//Uppercase 65 - 90
                if (value > 90) {
                    value = 64 + ((value - 90) % 26);
                }
            }

            char result = (char) value;
            sb.append(result);
        }
        System.out.println(sb);
    }
}
