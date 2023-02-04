package _45_n_arrows;

import java.util.Arrays;

/**
 * @author Ikechi Ucheagwu
 * @created 02/02/2023 - 20:12
 * @project Algo Github
 */
public class NArrows {
    public static void main(String[] args) {
        String str = "^vv<v"; //-> 2
        String str1 = "v>>>vv"; //-> 3
        String str2 = "<<<"; //-> 0
        String str3 = ""; //-> 0
        String str4 = "<^<v^>>v"; //-> 6
        String str5 = "^^vv<<>>"; //-> 6
        String str6 = "^<>v<<^v^<><v<^<>>^vv"; //-> 14

        System.out.println(solution(str));
        System.out.println(solution(str1));
        System.out.println(solution(str2));
        System.out.println(solution(str3));
        System.out.println(solution(str4));
        System.out.println(solution(str5));
        System.out.println(solution(str6));
    }

    private static int solution(String str) {
        int[] arr = new int[4];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '^') {
                arr[0]++;
            }
            if (ch == 'v') {
                arr[1]++;
            }
            if (ch == '<') {
                arr[2]++;
            }
            if (ch == '>') {
                arr[3]++;
            }
        }

        int min = Integer.MIN_VALUE;
        int max = 0;
        int position = 0;
        for (int i = 0; i < arr.length; i++) {
            int ele = arr[i];

            if (ele > min) {
                position = i;
                min = max = ele;
            }
        }

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != position) {
                result += arr[i];
            }
        }

        System.out.print("MAX is " + max + ". Array is " + Arrays.toString(arr) + ". Then output is: ");
        return result;
    }
}
