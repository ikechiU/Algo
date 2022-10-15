package org.example._15_tandem_bicycle;

import java.util.Arrays;
import java.util.Collections;


//Greedy Algorithm it forces you to choose a particular value, sorting is often used
// TC -> O(nlogn) SC -> O(1)
public class TandemBicycle {
    public static void main(String[] args) {
        int[]redShirtSpeed = {5, 5, 3, 9, 2};
        int[]blueShirtSpeed = {3, 6, 7, 2, 1};

        System.out.println(checkSpeed(redShirtSpeed, blueShirtSpeed, true));
        System.out.println(checkSpeed(redShirtSpeed, blueShirtSpeed, false));
    }

    private static int checkSpeed(int[] blueShirtSpeed, int[] redShirtSpeed, boolean check) {
        int total = 0;

        if (check) { //check = true i.e fastest speed
            var bArr = Arrays.stream(blueShirtSpeed).boxed().toArray(Integer[]::new);
            Arrays.sort(bArr, Collections.reverseOrder());
            Arrays.sort(redShirtSpeed);

            for (int i = 0; i < blueShirtSpeed.length; i++) {
                total += Math.max(bArr[i], redShirtSpeed[i]);
            }
        } else { //check = false i.e minimum speed
            Arrays.sort(blueShirtSpeed);
            Arrays.sort(redShirtSpeed);

            for (int i = 0; i < blueShirtSpeed.length; i++) {
                total += Math.max(blueShirtSpeed[i], redShirtSpeed[i]);
            }
        }
        return total;
    }
}
