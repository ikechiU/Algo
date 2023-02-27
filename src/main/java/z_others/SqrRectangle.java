package z_others;

import java.util.ArrayList;
import java.util.List;

public class SqrRectangle {

    public static void main(String[] args) {
        System.out.println(sqInRect(6, 4));
    }

    public static List<Integer> sqInRect(int lng, int wdth) {
        // your code
        List<Integer> returnValue = new ArrayList<>();


        if (lng == wdth) {
            returnValue = null;
        } else {
            var area = lng * wdth;

            while (area > 0) {
                if (lng > wdth) {
                    area = (int) (area - Math.pow(wdth, 2));
                    System.out.println("One " + area);
                    lng = lng - wdth;
                    returnValue.add(wdth);
                } else {
                    area = (int) (area - Math.pow(lng, 2));
                    System.out.println("Two " + area);
                    wdth = wdth - lng;
                    returnValue.add(lng);
                }
            }
        }

        return returnValue;
    }


}
