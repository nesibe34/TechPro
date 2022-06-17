package Sudoku;

import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {


    public static String[][] buildSudokuMatrix(){
        String[][] matrix=new String[9][9];
        matrix[0][0]="5";        matrix[0][1]="3";        matrix[0][4]="7";        matrix[1][0]="6";
        matrix[1][3]="1";        matrix[1][4]="9";        matrix[1][5]="5";        matrix[2][1]="9";
        matrix[2][2]="8";        matrix[2][7]="6";        matrix[3][0]="8";        matrix[3][4]="6";
        matrix[3][8]="3";        matrix[4][0]="4";        matrix[4][3]="8";        matrix[4][5]="3";
        matrix[4][8]="1";        matrix[5][0]="7";        matrix[5][4]="2";        matrix[5][8]="6";
        matrix[6][1]="6";        matrix[7][3]="4";        matrix[7][4]="1";
        matrix[7][5]="9";        matrix[7][8]="5";        matrix[8][4]="8";
        matrix[8][7]="7";        matrix[8][8]="9";
        return matrix;
    }
    public static void displaySudoku(String[][] matrix){
        System.out.println("----------------------------------");
        for (int i=0;i<9;i++) {
            for (int j = 0; j<9; j++) {
                if (matrix[i][j]==null) {
                    matrix[i][j] = "-";
                }
                if (j%3==0){
                    System.out.print("| ");
                    System.out.print(matrix[i][j]+"  ");
                }else if (j==8){
                    System.out.print(matrix[i][j]+"  ");
                    System.out.print("|");

                }else{
                    System.out.print(matrix[i][j]+"  ");
                }
            }
            System.out.println();
            if (i%3==2){
                System.out.println("----------------------------------");
            }
        }
    }
    public static String[][] fillOutSudokuMatrix(String[][] matrix){
        String[][] filledMatrix =new String[9][9];
        Scanner inp=new Scanner(System.in);
        System.out.println("Fill out empty grids.");
        for (int i=0;i<9;i++) {
            for (int j = 0; j<9; j++) {
                if (matrix[i][j].equals("-")) {
                    System.out.print("Enter a number between 1-9 for cell ("+(i+1)+","+(j+1)+"):");
                    String number= inp.next();
                    if (Integer.parseInt(number)>0 && Integer.parseInt(number)<10){
                        filledMatrix[i][j] = number;
                    }else {
                        System.out.println("You can not enter number other than (1 - 9).");
                    }
                }else{
                    filledMatrix[i][j]=matrix[i][j];
                }

            }
        }
        return filledMatrix;
    }
    public static Boolean isValidSolution(String[][] matrix){
        boolean isCheck=true;
        String[] row=new String[9];
        String[] column=new String[9];
        String[] block=new String[9];
        int idx=0;

        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                row[j]=matrix[i][j];
            }
            if (!isValidRules(row)){
                return false;
            }
        }
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                column[j]=matrix[j][i];
            }
            if (!isValidRules(column)){
                return false;
            }
        }
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++) {
                idx=0;
                for(int roww=3*i;roww<3*i+3;roww++){
                    for (int col=3*j;col<3*j+3;col++){
                        block[idx]=matrix[roww][col];
                        idx++;
                    }
                }
                if (!isValidRules(block)){
                    return false;
                }
            }
        }
       return true;
    }
    public static Boolean isValidRules(String[] array){

        int counter=0;
        Arrays.sort(array);
        for (int i=0;i<9;i++){
            if (!String.valueOf(i+1).equals(array[i])){
                counter++;
            }
            if(counter>0){
                return false;
            }
        }
        return true;
    }

}
