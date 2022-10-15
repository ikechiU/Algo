package _21_sudoku_solution_validator;

import java.util.*;

public class SudokuSolutionValidator {
    public static void main(String[] args) {
        //Check test cases in test package
    }

    public boolean check(int[][] sudoku) {
        System.out.println(Arrays.deepToString(sudoku));
        int rowLength = sudoku.length;
        int columnLength = sudoku[0].length;

        if(rowLength != 9 || columnLength != 9) return false;

        Set<Integer> set = new HashSet<>();
        Set<Integer> block1 = new HashSet<>();
        Set<Integer> block2 = new HashSet<>();
        Set<Integer> block3 = new HashSet<>();

        int count = 0;
        for (int[] ints : sudoku) {
            count++;

            for (int j = 0; j < ints.length; j++) {
                int ele = ints[j];
                if (ele == 1 || ele == 2 || ele == 3 || ele == 4 || ele == 5 || ele == 6 || ele == 7 || ele == 8 || ele == 9) {
                    set.add(ele);

                    if (j <= 2) {
                        block1.add(ele);
                    }
                    if (j >= 3 && j <= 5) {
                        block2.add(ele);
                    }
                    if (j >= 6 && j <= 8) {
                        block3.add(ele);
                    }
                }
            }

            if (set.size() == 9) set.clear();
            else return false;

            if (count == 3) {
                count = 0;
                if (block1.size() == 9) block1.clear();
                else return false;
                if (block2.size() == 9) block2.clear();
                else return false;
                if (block3.size() == 9) block3.clear();
                else return false;
            }

        }
        return true;
    }

    public boolean check2(int[][] sudoku) {
        System.out.println(Arrays.deepToString(sudoku));
        int rowLength = sudoku.length;
        int columnLength = sudoku[0].length;

        if(rowLength != 9 || columnLength != 9) return false;

        Set<Integer> set = new HashSet<>();
        Set<Integer> block1 = new HashSet<>();
        Set<Integer> block2 = new HashSet<>();
        Set<Integer> block3 = new HashSet<>();

        int count = 0;
        for (int[] ints : sudoku) {
            count++;

            for (int j = 0; j < ints.length; j++) {
                int ele = ints[j];
                if (ele == 1 || ele == 2 || ele == 3 || ele == 4 || ele == 5 || ele == 6 || ele == 7 || ele == 8 || ele == 9) {
                    set.add(ele);

                    if (j <= 2) {
                        block1.add(ele);
                    }
                    if (j >= 3 && j <= 5) {
                        block2.add(ele);
                    }
                    if (j >= 6 && j <= 8) {
                        block3.add(ele);
                    }
                }
            }

            if (set.size() == 9) set.clear();
            else return false;

            if (count == 3) {
                count = 0;
                if (block1.size() == 9) block1.clear();
                else return false;
                if (block2.size() == 9) block2.clear();
                else return false;
                if (block3.size() == 9) block3.clear();
                else return false;
            }

        }
        return true;
    }
}
