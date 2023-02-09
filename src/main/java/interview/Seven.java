package interview;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ikechi Ucheagwu
 * @created 09/02/2023 - 02:23
 * @project Algo Github
 */

/*
Given N points on a 2D plane Find the maximum number of points which can be covered by a rectangle with length x and breadth y.

A point is said to be covered by a rectangle if it lies on the sides or inside the rectangle

Example 1:

Input:

N=5 Points = {(1,1), (2,3), (3,4), (2,4), (5,5)} x=2, y=2
Output = 3.

Here we can see that this rectangle covers maximum point

Your Task:

You don't need to read input or print anything. Your task is to complete the function maximumPoints()
which takes N, arr (2D list of points), x and y as input parameters and returns an integer denoting maximum number
of points that can be covered by rectangle of size x*y.

Constraints:

1 <= N <= 10 ^ 5

1<=arr[i][0] arr[i][1] <=1000

1 <= x, y <= 1000
*/

public class Seven {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();

        int N = 5;

        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 3);
        Point p3 = new Point(3, 4);
        Point p4 = new Point(2, 4);
        Point p5 = new Point(5, 5);

        Point[] points = {p1, p2, p3, p4, p5};
        int x = 2, y = 2;

        int[][] ints = {{1,1}, {2,3}, {3,4}, {2,4}, {5,5}};

        System.out.println(maximumPoints(N, points, x, y)); //Output = 3.
        System.out.println(maximumPoints(N, ints, x, y)); //Output = 3.
    }

    public static int maximumPoints(int N, Point[] points, int x, int y) {

        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Point point = points[i];
            String key = point.x + "," + point.y;
            count.put(key, count.getOrDefault(key, 0) + 1);
        }

        int maxPoints = 0;
        for (int i = 0; i < N; i++) {
            Point point = points[i];
            double leftX = point.x - x / 2.0;
            double rightX = point.x + x / 2.0;
            double topY = point.y + y / 2.0;
            double bottomY = point.y - y / 2.0;

            int pointsCount = 0;
            for (int j = 0; j < N; j++) {
                Point curr = points[j];
                if (curr.x >= leftX && curr.x <= rightX && curr.y >= bottomY && curr.y <= topY) {
                    String key = curr.x + "," + curr.y;
                    pointsCount += count.get(key);
                }
            }

            maxPoints = Math.max(maxPoints, pointsCount);
        }

        return maxPoints;
    }


    public static int maximumPoints(int N, int[][] arr, int x, int y) {

        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int[] point = arr[i];
            String key = point[0] + "," + point[1];
            count.put(key, count.getOrDefault(key, 0) + 1);
        }

        int maxPoints = 0;
        for (int i = 0; i < N; i++) {
            int[] point = arr[i];
            int leftX = point[0] - x / 2;
            int rightX = point[0] + x / 2;
            int topY = point[1] + y / 2;
            int bottomY = point[1] - y / 2;

            int points = 0;
            for (int j = 0; j < N; j++) {
                int[] curr = arr[j];
                if (curr[0] >= leftX && curr[0] <= rightX && curr[1] >= bottomY && curr[1] <= topY) {
                    String key = curr[0] + "," + curr[1];
                    points += count.get(key);
                }
            }

            maxPoints = Math.max(maxPoints, points);
        }

        return maxPoints;
    }

    public static void fourthQuestion(){
        Rectangle r1 = new Rectangle(0, 0, 100, 50);
        Rectangle r2 = new Rectangle(0, 0, 100, 50);
        r2.grow(10, 20);
        System.out.println(r1);
        System.out.println(r2);
    }
}



