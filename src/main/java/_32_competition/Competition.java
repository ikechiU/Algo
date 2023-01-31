package _32_competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ikechi Ucheagwu
 * @created 26/01/2023 - 00:52
 * @project Algo Github
 */

/* Consider a league-style competition with several teams competing against each other in matches.
Each match comprises two teams playing against each other. Teams try to score goals during a match
and the team that scores the most goals wins. The competition uses a point system to determine
team rankings - after a match, the winning team receives 3 points, the losing team receives
0 points or in case of a tie/draw both teams receives 1 point.
The winner of the competition is the team that accumulates the most points. In case of a tie,
the winner is the team with the highest goal difference. The team with the second place is the
team that got more points (or the highest goal difference, in the case of a tie) than every other
team except the competitions' winner. It is guaranteed that there will only be one winner in the
competition and one team gets the second place.
You are given 4 arrays of the same length: wins, draws, scored and conceded. Within each array,
the ith element represents the corresponding metric for the ith team - i.e. Scored goals scored[i],
conceded goals conceded[i], matches won wins[i] and matches tied draws[i] during the competition
(for each i in 0, 1, ... wins.length - 1).
Goal difference is calculated as scored_goals - conceded_goals where scored_goals is the total number
of goals scored during the competition, and conceded_goals is the total number of goals conceded
during the competition.
Your task is to determine the indices of the winning team and the team that got the second place.

wins = [2, 1, 0], draws = [1, 5, 6], scored = [20, 15, 10] conceded = [20, 10, 15] output = [1, 0]
wins = [3, 1, 2, 2], draws = [1, 5, 4, 4], scored = [10, 10, 20, 40] conceded = [32, 13, 18, 37] output = [3, 2] */

public class Competition {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getWinners(new int[]{2, 1, 0}, new int[]{1, 5, 6}, new int[]{20, 15, 10}, new int[]{20, 15, 10})));
        System.out.println(Arrays.toString(getWinners(new int[]{3, 1, 2, 2}, new int[]{1, 5, 4, 4}, new int[]{10, 10, 20, 40}, new int[]{32, 13, 18, 37})));
    }

    public static int[] getWinners(int[] wins, int[] draws, int[] scored, int[] conceded) {
        int[] result = new int[2];

        // Create a list of teams
        List<Team> teams = new ArrayList<>();
        for (int i = 0; i < wins.length; i++) {
            teams.add(new Team(i, wins[i], draws[i], scored[i], conceded[i]));
        }

        // Sort the teams based on points and goal difference
        Collections.sort(teams);

        // The first team in the sorted list is the winner
        result[0] = teams.get(0).getIndex();

        // The second team in the sorted list is the second place
        result[1] = teams.get(1).getIndex();

        return result;
    }
}

class Team implements Comparable<Team> {
    private final int index;
    private final int wins;
    private final int draws;
    private final int scored;
    private final int conceded;

    public Team(int index, int wins, int draws, int scored, int conceded) {
        this.index = index;
        this.wins = wins;
        this.draws = draws;
        this.scored = scored;
        this.conceded = conceded;
    }

    public int getIndex() {
        return index;
    }

    public int getPoints() {
        return wins * 3 + draws;
    }

    public int getGoalDifference() {
        return scored - conceded;
    }

    @Override
    public int compareTo(Team other) {
        if (this.getPoints() != other.getPoints()) {
            return other.getPoints() - this.getPoints();
        } else {
            return other.getGoalDifference() - this.getGoalDifference();
        }
    }
}


