package _14_class_photo;

import java.util.Arrays;

public class ClassPhoto {
    public static void main(String[] args) {
        int[] redShirt = {5, 8, 1, 3, 4};
        int[] blueShirt = {6, 9, 2, 4, 5};

        System.out.println(canTakeClassPhoto(blueShirt, redShirt));;
    }

    //TC -> O(NLogN) //O(1)
    private static boolean canTakeClassPhoto(int[] blueShirt, int[] redShirt) {
        Arrays.sort(blueShirt);
        Arrays.sort(redShirt);

        int tallestBlueShirt = blueShirt[blueShirt.length - 1];
        int tallestRedShirt = redShirt[redShirt.length - 1];

        boolean checkPattern;

        if (tallestBlueShirt > tallestRedShirt) checkPattern = true;
        else if (tallestRedShirt > tallestBlueShirt) checkPattern = false;
        else return false;

        for (int i = blueShirt.length - 2; i >= 0; i--) {
            if (checkPattern) {
                if (blueShirt[i] <= redShirt[i]) return false;
            } else {
                if (redShirt[i] <= blueShirt[i]) return false;
            }
        }

        return true;
    }
}
