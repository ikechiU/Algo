package _52_rectangle_cordinates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ikechi Ucheagwu
 * @created 06/02/2023 - 20:00
 * @project Algo Github
 */

/*
* Given two arrays x[] and y[] with n-elements, where (xi, yi) represent a point on coordinate system,
* find the smallest rectangle such that all points from given input lie inside that rectangle and
* sides of rectangle must be parallel to Coordinate axis. Print all four coordinates of an obtained rectangle.
* Note: n >= 4 (we have at least 4 points as input).
*/
public class RectangleCoordinates {

    public static void main(String[] args) {
        //Input : X[] = {1, 3, 0, 4},  y[] = {2, 1, 0, 2}
        //Output : {0, 0}, {0, 2}, {4, 2}, {4, 0}

        //find the smallest rectangle such that all points from given input lie inside that rectangle and
        //sides of rectangle must be parallel to Coordinate axis
        int[] x = {1, 3, 0, 4}, y = {2, 1, 0, 2};
        int[] x1 = {3, 6, 1, 9, 13, 0, 4}, y1 = {4, 2, 6, 5, 2, 3, 1};
        List<List<Integer>> result =  rectangleCoordinates(x, y); //Output : {0, 0}, {0, 2}, {4, 2}, {4, 0}
        List<List<Integer>> result2 =  rectangleCoordinates(x1, y1); //Output : {0, 1}, {0, 6}, {13, 6}, {13, 1}
        List<List<Integer>> result3 =  rectangleCoordinates2(x, y); //Output : {0, 0}, {0, 2}, {4, 2}, {4, 0}
        List<List<Integer>> result4 =  rectangleCoordinates2(x1, y1); //Output : {0, 1}, {0, 6}, {13, 6}, {13, 1}
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    private static List<List<Integer>> rectangleCoordinates(int[] x, int[] y) {
        Arrays.sort(x);
        Arrays.sort(y);

        return new ArrayList<>(List.of(List.of(x[0], y[0]), List.of(x[0], y[y.length - 1]), List.of(x[x.length - 1], y[y.length - 1]), List.of(x[x.length - 1], y[0])));
    }

    private static List<List<Integer>> rectangleCoordinates2(int[] x, int[] y) {
        Integer[] X = Arrays.stream(x).boxed().toArray(Integer[]::new);
        Integer[] Y = Arrays.stream(y).boxed().toArray(Integer[]::new);
        int xMax = Collections.max(Arrays.asList(X));
        int xMin = Collections.min(Arrays.asList(X));

        int yMax = Collections.max(Arrays.asList(Y));
        int yMin = Collections.min(Arrays.asList(Y));

        return List.of(List.of(xMin, yMin), List.of(xMin, yMax), List.of(xMax, yMax), List.of(xMax, yMin));
    }
}
