package _50_suggested_meeting_time;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ikechi Ucheagwu
 * @created 05/02/2023 - 20:26
 * @project Algo Github
 */

public class Booking {

    /*
     * N/B: All time in minutes
     * Find the earliest available time for a meeting to be scheduled.
     * If multiple time slots are available your function should return the first
     * If it is not possible to suggest a time for a given input your function should output "No time available"
     */

    public static void main(String[] args) {
        Interval workingHours = new Interval(480, 1080);
        List<Interval> meetings = new ArrayList<>(
                List.of(new Interval(600, 660), new Interval(720, 780), new Interval(780, 825), new Interval(900, 940))
        );
        int currentTime = 780;
        int duration = 45;
        String result = suggestedMeetingTime(workingHours, meetings, currentTime, duration);
        String result2 = suggestedMeetingTime2(workingHours, meetings, currentTime, duration);
        System.out.println(result);
        System.out.println(result2);
    }

    private static String suggestedMeetingTime(Interval workingHours, List<Interval> meetings, int currentTime, int duration) {
        Interval first = new Interval(workingHours.getStart(), meetings.get(0).getStart());
        Interval last = new Interval(meetings.get(meetings.size() - 1).getEnd(), workingHours.getEnd());

        List<Interval> availableIntervals = new ArrayList<>();
        if (first.getEnd() - first.getStart() > 0)
            availableIntervals.add(first);

        for (int i = 1; i < meetings.size(); i++) {
            int start = meetings.get(i).getStart();
            int end = meetings.get(i - 1).getEnd();

            if (start - end != 0) {
                availableIntervals.add(new Interval(end, start));
            }
        }

        if (last.getEnd() - last.getStart() > 0)
            availableIntervals.add(last);

        System.out.println(availableIntervals);

        List<Interval> collect = availableIntervals.stream()
                .filter(interval -> interval.getStart() >= currentTime &&
                        interval.getEnd() - interval.getStart() >= duration).toList();

        return collect.size() != 0 ?
                new Interval(collect.get(0).getStart(), collect.get(0).getStart() + duration).toString()
                : "No time available";
    }

    private static String suggestedMeetingTime2(Interval workingHours, List<Interval> meetings, int currentTime, int duration) {
        int firstStart = workingHours.getStart();
        int firstEnd = meetings.get(0).getStart();

        if (firstEnd - firstStart > 0) {
            if (firstStart >= currentTime && firstEnd - firstStart >= duration) {
                Interval interval = new Interval(firstStart, firstStart + duration);
                return interval.toString();
            }
        }

        for (int i = 1; i < meetings.size(); i++) {
            int start = meetings.get(i).getStart();
            int end = meetings.get(i - 1).getEnd();

            if (start - end != 0) {
                if (end >= currentTime && start - end >= duration) {
                    Interval interval = new Interval(end, end + duration);
                    return interval.toString();
                }
            }
        }

        int lastStart = meetings.get(meetings.size() - 1).getEnd();
        int lastEnd = workingHours.getEnd();

        if (lastEnd - lastStart > 0) {
            if (lastStart >= currentTime && lastEnd - lastStart >= duration) {
                Interval interval = new Interval(lastStart, lastStart + duration);
                return interval.toString();
            }
        }

        return "No time available";
    }
}
