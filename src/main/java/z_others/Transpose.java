package z_others;

import java.util.ArrayList;
import java.util.Arrays;

public class Transpose {

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2}, {3, 4}};
//        int[][] matrix1 = {{1, 7, 9}, {2, 3, 5}};
//        int[][] matrix2 = {{9, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 7}, {1, 3, 1, 5}};
//        int[][] matrix3 = {{1, 2, 3, 4, 5}};
//        int[][] matrix4 = {{-7, 12, 13, 0, 17, 21}, {-1, 5, -2, 9, 11, 2}, {5, -3, 12, 15, 13, 4}, {9, 22, 13, 35, 1, 24}, {11, 15, 4, 1, 8, -5}, {2, 30, -4, 24, -5, 16}};
        int[][] matrix5 = {{1, 2, 3, 4, 5, 6, 7, 8, 9}, {11, 22, 33, 44, 55, 66, 77, 88, 99}, {2, 4, 6, 8, 10, 12, 14, 16, 18}, {1, 3, 5, 7, 9, 11, 13, 15, 17},
                {1, 1, 2, 3, 5, 8, 13, 21, 34}, {2, 3, 5, 7, 11, 13, 17, 19, 23}, {1, 4, 9, 16, 25, 36, 49, 64, 81}, {3, 1, 4, 1, 5, 9, 2, 6, 5}, {2, 7, 1, 8, 2, 8, 1, 8, 2}};

//        System.out.println(Arrays.deepToString(transpose(matrix)));
//        System.out.println(Arrays.deepToString(transpose(matrix1)));
//        System.out.println(Arrays.deepToString(transpose(matrix2)));
//        System.out.println(Arrays.deepToString(transpose(matrix3)));
//        System.out.println(Arrays.deepToString(transpose(matrix4)));
        System.out.println(Arrays.deepToString(transpose(matrix5)));
    }

    //row(arr.length) X column(arr[0].length)
    private static int[][] transpose(int[][] arr) {
        var row = arr.length;
        var column = arr[0].length;

        int[][] newArr = new int[column][row];

        StringBuilder rowPosition = new StringBuilder();
        StringBuilder columnPosition = new StringBuilder();
        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            var eleRow = arr[i];

            for (int j = 0; j < eleRow.length; j++) {
                var ele = eleRow[j];

                rowPosition.append(i);
                columnPosition.append(j);
                values.add(ele);
            }
        }

        var r = new String(rowPosition);
        var c = new String(columnPosition);

        for (int i = 0; i < r.length(); i++) {
            int arrValue = values.get(i);

            var indexI = Integer.parseInt(String.valueOf(c.charAt(i)));
            var indexJ = Integer.parseInt(String.valueOf(r.charAt(i)));

            newArr[indexI][indexJ] = arrValue;
        }

        System.out.println(Arrays.deepToString(arr));
        return newArr;
    }


}
