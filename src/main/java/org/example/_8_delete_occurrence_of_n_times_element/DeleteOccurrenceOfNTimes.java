package org.example._8_delete_occurrence_of_n_times_element;

import java.util.Arrays;

public class DeleteOccurrenceOfNTimes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteNth(new int[]{1, 2, 3, 1, 2, 1, 2, 3}, 2)));
        System.out.println(Arrays.toString(deleteNth(new int[]{20,37,21}, 1)));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if (maxOccurrences == 0) return new int[] {};

        var strElements = Arrays.toString(elements);
        var strArr = strElements.substring(1, strElements.length() - 1).split(", ");

        int count;
        for (int i = 0; i < strArr.length; i++) {
            count = 1;
            String stringI = strArr[i];

            for (int j = i + 1; j < strArr.length; j++) {
                String stringJ = strArr[j];
                if (stringI.equals(stringJ)) count++;

                if (count > maxOccurrences)
                    if (stringI.equals(stringJ)) strArr[j] = "";
            }
        }

        int countNonEmpty = 0;
        for (String s : strArr)
            if (!s.equals("")) countNonEmpty++;

        int indexI = 0;
        int[] returnValue = new int[countNonEmpty];
        for (String s : strArr) {
            if (!s.equals(""))  {
                returnValue[indexI] = Integer.parseInt(s);
                indexI++;
            }
        }

        return returnValue;
    }
}
