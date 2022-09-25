package org.example._8_delete_occurrence_of_n_times_element;

import java.util.Arrays;

public class DeleteOccurrenceOfNTimes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteNth(new int[]{1, 2, 3, 1, 2, 1, 2, 3}, 2)));
        System.out.println(Arrays.toString(deleteNth(new int[]{20,37,21}, 1)));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if (maxOccurrences == 0) return new int[] {};

        String[] strArr = new String[elements.length];
        for (int i = 0; i < elements.length; i++) {
            strArr[i] = String.valueOf(elements[i]);
        }

        int count = 1;
        for (int i = 0; i < strArr.length; i++) {
            count = 1;
            String stringI = strArr[i];

            for (int j = i + 1; j < strArr.length; j++) {
                String stringJ = strArr[j];
                if (stringI.equals(stringJ)) count++;

                if (count > maxOccurrences) {
                    if (stringI.equals(stringJ)) strArr[j] = "";
                }
            }
        }

        int countNonEmpty = 0;
        for(int i = 0; i < strArr.length; i++) {
            if (strArr[i] != "") countNonEmpty++;
        }

        int indexI = 0;
        int[] returnValue = new int[countNonEmpty];
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != "") {
                returnValue[indexI] = Integer.parseInt(strArr[i]);
                indexI++;
            }
        }

        return returnValue;
    }
}
