package _50_suggested_meeting_time;

/**
 * @author Ikechi Ucheagwu
 * @created 05/02/2023 - 20:29
 * @project Algo Github
 */


public class Interval {
    private final int start;
    private final int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
