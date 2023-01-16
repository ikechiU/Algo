package _24_Codelona;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ikechi Ucheagwu
 * @created 11/01/2023 - 10:57 AM
 * @project AlgoInterview
 */

/*
* Fc Codelona is trying to assemble a team from a roster of available players.
* They have a minimum number of players they want to sign and each player needs to have a skill
* rating within a certain range.Given a list of players skill levels with desired upper and
* lower bounds,determine how many teams can be created from the list.
Example: skills=[12,4,6,13,5,10]
minPlayers=3
minLevel=4
maxLevel=10

The list includes players with skill levels [12,4,6,13,5,10]
They want to hire at least 3 players with the skill levels between 4 and 10 inclusive.
Four the players with the following skill levels {4,6,5,10} meet criteria.
There are 5 ways to form a team of at least 3 players : {4,5,6} ,{4,6,10},{4,5,10},{5,6,10} and { 4,5,6,10}
Return 5.*/

/*
* To determine the number of teams that can be created from the list of players with the given skill levels
* and desired upper and lower bounds, you can use a combination algorithm.

First, filter the list to only include players with skill levels between the minLevel and maxLevel, inclusive.
* Then, use the combination algorithm to find all possible combinations of players that meet the minimum number
* of players required (minPlayers). The number of combinations will be the number of teams that can be created from the list of players.

For example, in the given case, the list of players that meet the criteria is [4, 6, 5, 10].
* Then you can use the combination algorithm to find all possible combinations of players that have at least 3 players, which is 5.*/

public class FcCodelona {

    public static int numTeams(int[] skills, int minPlayers, int minLevel, int maxLevel) {
        List<Integer> players = new ArrayList<>();

        //Filter players with skill levels between min and max level
        for (int skill : skills) {
            if (minLevel <= skill && skill <= maxLevel) {
                players.add(skill);
            }
        }

        //Find all possible combinations of players that meet the minimum number of players required
        int teamCount = 0;
        for (int i = minPlayers; i <= players.size(); i++) {
            teamCount += combination(players.size(), i);
        }

        return teamCount;
    }

    //Helper method to calculate combination
    public static int combination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    //Helper method to calculate factorial
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] skills = {12, 4, 6, 13, 5, 10};
        int minPlayers = 3;
        int minLevel = 4;
        int maxLevel = 10;

//        //5812
//        int[] skills = {732, 217, 930, 274, 936, 432, 618, 283, 494, 780, 140, 376, 82, 736, 337}; //32647
//        int minPlayers = 6;
//        int minLevel = 186;
//        int maxLevel = 973;

        System.out.println(numTeams(skills, minPlayers, minLevel, maxLevel));
        // Output: 5
    }
}
