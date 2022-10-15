package org.example._21_sudoku_solution_validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolutionValidatorTest {

    @Test
    void check() {
        SudokuSolutionValidator solutionValidator = new SudokuSolutionValidator();
        assertFalse(solutionValidator.check(sudoku));
        assertFalse(solutionValidator.check(sudoku1));
        assertTrue(solutionValidator.check(sudoku2));
        assertFalse(solutionValidator.check(sudoku3));
        assertTrue(solutionValidator.check(sudoku4));
        assertTrue(solutionValidator.check(sudoku5));
        assertTrue(solutionValidator.check(sudoku6));
        assertFalse(solutionValidator.check(sudoku7));
    }

    int[][] sudoku = {{}};

    int[][] sudoku1 = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}};

    int[][] sudoku2 = {{5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8}, 
            {1, 9, 8, 3, 4, 2, 5, 6, 7}, 
            {8, 5, 9, 7, 6, 1, 4, 2, 3}, 
            {4, 2, 6, 8, 5, 3, 7, 9, 1}, 
            {7, 1, 3, 9, 2, 4, 8, 5, 6}, 
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}};

    int[][] sudoku3 =  {{6, 2, 4, 6, 7, 8, 9, 1, 2},
            {5, 8, 2, 1, 9, 5, 3, 4, 8}, 
            {1, 9, 8, 3, 4, 2, 5, 6, 7}, 
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1}, 
            {7, 1, 3, 9, 2, 4, 8, 5, 6}, 
            {9, 6, 1, 5, 3, 7, 2, 8, 4}, 
            {2, 8, 7, 4, 1, 9, 6, 3, 5}, 
            {3, 4, 5, 2, 8, 6, 1, 7, 9}};


    int[][] sudoku4 = {{2, 1, 3, 6, 4, 5, 7, 8, 9},
            {5, 4, 6, 9, 7, 8, 1, 2, 3},
            {8, 7, 9, 3, 1, 2, 4, 5, 6},
            {6, 5, 7, 1, 8, 9, 2, 3, 4},
            {9, 8, 1, 4, 2, 3, 5, 6, 7},
            {3, 2, 4, 7, 5, 6, 8, 9, 1},
            {1, 9, 2, 5, 3, 4, 6, 7, 8},
            {4, 3, 5, 8, 6, 7, 9, 1, 2},
            {7, 6, 8, 2, 9, 1, 3, 4, 5}};

    int[][] sudoku5 = {{1, 2, 3, 6, 4, 5, 9, 8, 7},
            {7, 8, 9, 3, 1, 2, 6, 5, 4},
            {4, 5, 6, 9, 7, 8, 3, 2, 1},
            {8, 9, 1, 4, 2, 3, 7, 6, 5},
            {2, 3, 4, 7, 5, 6, 1, 9, 8},
            {5, 6, 7, 1, 8, 9, 4, 3, 2},
            {9, 1, 2, 5, 3, 4, 8, 7, 6},
            {3, 4, 5, 8, 6, 7, 2, 1, 9},
            {6, 7, 8, 2, 9, 1, 5, 4, 3}};

    int[][] sudoku6 = {{4, 5, 6, 7, 8, 9, 2, 1, 3},
            {1, 2, 3, 4, 5, 6, 8, 7, 9}, 
            {7, 8, 9, 1, 2, 3, 5, 4, 6}, 
            {2, 3, 4, 5, 6, 7, 9, 8, 1}, 
            {8, 9, 1, 2, 3, 4, 6, 5, 7}, 
            {5, 6, 7, 8, 9, 1, 3, 2, 4}, 
            {6, 7, 8, 9, 1, 2, 4, 3, 5}, 
            {9, 1, 2, 3, 4, 5, 7, 6, 8}, 
            {3, 4, 5, 6, 7, 8, 1, 9, 2}};

    int[][] sudoku7 = {{4, 5, 6, 7, 8, 9, 2, 1},
            {1, 2, 3, 4, 5, 6, 8, 7},
            {7, 8, 9, 1, 2, 3, 5, 4},
            {2, 3, 4, 5, 6, 7, 9, 8},
            {8, 9, 1, 2, 3, 4, 6, 5},
            {5, 6, 7, 8, 9, 1, 3, 2},
            {6, 7, 8, 9, 1, 2, 4, 3},
            {9, 1, 2, 3, 4, 5, 7, 6},
            {3, 4, 5, 6, 7, 8, 1, 9}};

}