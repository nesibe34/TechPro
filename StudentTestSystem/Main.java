package StudentTestSystem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.println("Please enter the name and grades of all tests for each students:");
        ArrayList<Student> arrayStudent=new ArrayList<>();
        for (int i=0;i<2;i++){
            arrayStudent.add(Student.std());
        }
        Student.listStdInfo(arrayStudent);

        int select= -1;

        while (select!=0){
            System.out.println("----[Menu]----");
            System.out.println("1-Average of student");
            System.out.println("2-Average of test");
            System.out.println("3-Average of class");
            System.out.println("0-Exit");
            select= inp.nextInt();
            switch (select) {
                case 1:
                    Student.averageStd(arrayStudent);
                    break;
                case 2:
                    Test.averageTest(arrayStudent);
                    break;
                case 3:
                    Student.classAverage(arrayStudent);
                    break;
                case 0:
                    select=0;
                    break;
                default:
                    System.out.println("Invalid login! Try again.");
                    select= inp.nextInt();
                    break;
            }
        }









    }
}

