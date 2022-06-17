package StudentTestSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    private String name;
    private int id;
    public double grade;
    public ArrayList<Double> gradeList;



    public Test(int id,String name) {
        this.name = name;
        this.id=id;
        this.grade=0;
        this.gradeList=new ArrayList<Double>();
    }
    public ArrayList<Double> listGradesTest(int id,ArrayList<Student> std){
        for (Student s:std){
            this.gradeList.add(s.testList.get(id-1).grade);
        }
        return gradeList;
    }

    public static void averageTest(ArrayList<Student> std){

        System.out.println("Enter the number of test to see average of it:");
        Scanner inp=new Scanner(System.in);
        int num= inp.nextInt();
        Test test=new Test(num,"test"+num);
        ArrayList<Double> grades=test.listGradesTest(num,std);
        double sum=0;
        double average=0;
        for (double d:grades){
            sum+=d;
        }
        average=sum/grades.size();
        System.out.println("Average of test"+num+" is : "+average);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
