package _61_test_gorilla_debugging_data_formatter;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ikechi Ucheagwu
 * @created 06/03/2023 - 00:21
 * @project Algo Github
 */

public class DateFormattingDebuggingTestGorilla {
    public static void main(String[] args) {
        String event = "The first human in space 12-03-1961"; //61years;2months;11days-The first human in space
        String event1 = "EventC 01-01-1903,Event A 04-01-1900, Event B 01-04-1900";//0years;0months;3days-Event A,0years;3months;0days-Event B,3years;0months;0days-EventC
        String event2 = "Wrong Format 1900-03-03,Correct Format 03-03-1900"; //0years;2months;2days-Correct Format
        String event3 = "New Year Party '00 01-01-1900"; //0years;0months;0days-New Year Party'00
        System.out.println(Arrays.toString(sorted(events(event))));
        System.out.println(Arrays.toString(sorted(events(event1))));
        System.out.println(Arrays.toString(sorted(events(event2))));
        System.out.println(Arrays.toString(sorted(events(event3))));
    }

    public static String[] sorted(String[] events) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final LocalDate now = LocalDate.of(1900, 1, 1);

        List<String> listOfEvents = new ArrayList<>();

        for (String event : events) {
            Optional<LocalDate> date = findDateInLine(event, formatter);
            if (date.isEmpty()) continue;
            Period timeLeft = Period.between(now, date.get());

            int dateIndex = event.indexOf(date.get().format(formatter));

            String title = event.substring(0, dateIndex).trim();

            String sb = timeLeft.getYears() + "years" + ";" +
                    timeLeft.getMonths() + "months" + ";" +
                    timeLeft.getDays() + "days" + "-" +
                    title;
            listOfEvents.add(sb);
        }

        listOfEvents.sort(String::compareTo);
        return listOfEvents.toArray(new String[0]);
    }

    private static Optional<LocalDate> findDateInLine(String line, DateTimeFormatter formatter) {
        String regex = "\\d{1,2}-\\d{1,2}-\\d{4}";

        Matcher m = Pattern.compile(regex).matcher(line);
        if (m.find()) {
            LocalDate date = LocalDate.parse(m.group(), formatter);
            return Optional.of(date);
        }

        return Optional.empty();
    }

    private static String[] events(String event) {
        return event.split(",");
    }

}
