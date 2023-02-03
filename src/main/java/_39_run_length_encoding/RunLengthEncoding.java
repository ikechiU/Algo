package _39_run_length_encoding;

/**
 * @author Ikechi Ucheagwu
 * @created 01/02/2023 - 19:50
 * @project Algo Github
 */

public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println(solution("AAAAAAAAAAAAAABBBBCCCDDDE"));
        System.out.println(solution("A"));
    }

    private static String solution(String str) {
        StringBuilder sb = new StringBuilder();

        char currChar = '1';
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            var ele = str.charAt(i);
            if (currChar == '1') {
                currChar = ele;
            }

            if (ele != currChar || count == 9) {
                sb.append(currChar).append(count);
                count = 0;
                currChar = ele;
            }
            count += 1;

            if (i == str.length() - 1) {
                sb.append(currChar).append(count);
            }
        }
        return sb.toString();
    }
}
