package Sudoku;

import java.util.Arrays;

public class Game {
    public static void main(String[] args) {
        String[][] sudoku=Sudoku.buildSudokuMatrix();
        Sudoku.displaySudoku(sudoku);
        String[][] mySudoku=Sudoku.fillOutSudokuMatrix(sudoku);
        Sudoku.displaySudoku(mySudoku);
        if (Sudoku.isValidSolution(mySudoku)){
            System.out.println("Congratulations! Your solution is valid.");
        }else{
            System.out.println("Unfortunely, your solution is INVALID!");
        }
    }
}
