package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ikechi Ucheagwu
 * @created 09/02/2023 - 21:18
 * @project java-dummy-recruitment-task-master
 */

public class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point[] points(List<List<Integer>> lists) {
        Point[] points = new Point[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = new ArrayList<>(lists.get(i));
            points[i] = new Point(list.get(0), list.get(1));
        }
        return points;
    }
}