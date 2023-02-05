package _49_uber_screening_question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ikechi Ucheagwu
 * @created 04/02/2023 - 21:06
 * @project Algo Github
 */

/*
* Given a stream of events . Each event has 3 parameters {driverId, timestamp at which event happened , type of event} .
*  Search the event/events that happened at (or just before) the given timestamp and by the given driver id .

Eg : Input Events
{1, 1250 , PICKUP}
{1, 1252, PICKUP}
{1, 1252, DROP}
{1, 2582 , DROP}
{3, 4590 , PICKUP}

On calling method Lookup (driverid -1 , timestamp - 1253)
Output -> {1,1252, DROP}

On calling method Lookup (driverid -1 , timestamp - 1252)
Output -> {1, 1252, PICKUP}
{1, 1252, DROP}*/

public class UberScreeningQuestion {

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        var one = List.of("1", "1250", "PICKUP");
        var two = List.of("1", "1252", "PICKUP");
        var three = List.of("1", "1252", "DROP");
        var four = List.of("1", "2582", "DROP");
        var five = List.of("3", "4590", "PICKUP");
        lists.add(one);
        lists.add(two);
        lists.add(three);
        lists.add(four);
        lists.add(five);

        //Search the event/events that happened at (or just before)
        System.out.println(solution(lists, List.of("1", "1253"))); //-> OUTPUT = {1, 1252, DROP}
        System.out.println(solution(lists, List.of("1", "1252"))); //-> OUTPUT = {1, 1252, PICKUP}
        System.out.println(solution(lists, List.of("0", "1252"))); //-> OUTPUT = null
    }


    private static List<String> solution(List<List<String>> lists, List<String> list) { //Assume the lists is sorted
        List<List<String>> listsOfDriverId =
                lists.stream().filter(l -> list.get(0).equals(l.get(0))).toList();

        if (listsOfDriverId.isEmpty()) return null;

        for (int i = 0; i < listsOfDriverId.size() - 1; i++) {
            List<String> strings1 = listsOfDriverId.get(i);
            List<String> strings2 = listsOfDriverId.get(i + 1);

            if (strings1.get(1).equals(list.get(1))) {
                return strings1;
            }

            if (strings2.get(1).equals(list.get(1))) {
                return strings2;
            }

            if (Integer.parseInt(strings2.get(1)) > Integer.parseInt(list.get(1))) {
                return strings1;
            }

        }

        return null;
    }
}
