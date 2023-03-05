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
        String[] result = sorted(new String[]{"The first human in space 12-03-1961"}); //61years;2months;11days-The first human in space
        String[] result1 = sorted(new String[]{"EventC 01-01-1903,Event A 04-01-1900, Event B 01-04-1900"});//0years;0months;3days-Event A,0years;3months;0days-Event B,3years;0months;0days-EventC
        String[] result2 = sorted(new String[]{"Wrong Format 1900-03-03,Correct Format 03-03-1900"}); //0years;2months;2days-Correct Format
        String[] result3 = sorted(new String[]{"New Year Party '00 01-01-1900"}); //0years;0months;0days-New Year Party'00
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
    }

    public static String[] sorted(String[] events) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final LocalDate now = LocalDate.of(1900, 1, 1);

        List<String> listOfEvents = new ArrayList<>();

        for (String event : findEvents(events)) {
            Optional<LocalDate> date = findDateInLine(event, formatter);
            if (date.isEmpty()) continue;
            Period timeLeft = Period.between(now, date.get());

            int dateIndex = event.indexOf(date.get().format(formatter));

//            String targetDate = String.valueOf(date.get());
//            String target = targetDate.substring(8) + "-" + targetDate.substring(5, 7) + "-" + targetDate.substring(0, 4);
//            String title = event.replace(target, "").trim();

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

    private static String[] findEvents(String[] events) {
        return events[0].split(",");
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

}
