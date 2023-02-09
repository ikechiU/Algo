package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ikechi Ucheagwu
 * @created 09/02/2023 - 21:23
 * @project java-dummy-recruitment-task-master
 */

public class Rectangle {

    private Point upperLeft;
    private Point bottomRight;

    public Rectangle() {}

    public Rectangle(Point upperLeft, Point bottomRight) {
        this.upperLeft = upperLeft;
        this.bottomRight = bottomRight;
    }

    public double area() {
        return length(upperLeft, bottomRight) * width(upperLeft, bottomRight);
    }

    public double perimeter() {
        return 2 * (length(upperLeft, bottomRight) + width(upperLeft, bottomRight));
    }

    public boolean isSquare() {
        return length(upperLeft, bottomRight) == width(upperLeft, bottomRight);
    }

    public Point centerPoint() {
        return new Point(length(upperLeft, bottomRight)/2, width(upperLeft, bottomRight)/2);
    }

    public int maxPointInXY(Point[] points, int x, int y) {
        Map<String, Integer> map = new HashMap<>();
        for (Point point : points) {
            String key = point.x + "," + point.y;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int maxPoints = 0;
        for (Point point : points) {
            double rightX = point.x + x / 2.0;
            double leftX = point.x - x / 2.0;
            double upperY = point.y + y / 2.0;
            double bottomY = point.y - y / 2.0;

            int pointCount = 0;
            for (Point currPoint : points) {
                if (currPoint.x >= leftX && currPoint.x <= rightX && currPoint.y >= bottomY && currPoint.y <= upperY) {
                    pointCount += map.get(currPoint.x + "," + currPoint.y);
                }
            }
            maxPoints = Math.max(maxPoints, pointCount);
        }

        return maxPoints;

    }

    public double length(Point upperLeft, Point bottomRight) {
        return bottomRight.x - upperLeft.x;
    }

    public double width(Point upperLeft, Point bottomRight) {
        return upperLeft.y - bottomRight.y;
    }
}
