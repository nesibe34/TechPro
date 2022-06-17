package StudentTestSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String name;
    public ArrayList<Test> testList;

    public Student(String name) {
        this.name = name;
        this.testList=new ArrayList<Test>();
    }

    public static Student std(){
        Scanner inp=new Scanner(System.in);
        Student std = new Student(inp.next());
        for (int i=0;i<3;i++){
            int grade=inp.nextInt();
            if (grade>0 && grade<=100){
                std.loginGradeTest((i+1),grade);
            }else {
                System.out.println("invalid login!");
            }
        }

        return std;
    }

    public static void listStdInfo(ArrayList<Student> std){
        System.out.println("===================================================");
        System.out.printf("%-9s  %-5s  %-5s  %-5s\n","Name","Test1","Test2","Test3");
        for (int i=0;i<std.size();i++){
            System.out.printf("%-1d.%-8s  %-5.1f  %-5.1f  %-5.1f\n",(i+1),std.get(i).getName(),std.get(i).testList.get(0).grade,std.get(i).testList.get(1).grade,
                    std.get(i).testList.get(2).grade);

        }
        System.out.println("===================================================");
    }

    public static Student getStdObjByName(String name, ArrayList<Student>  std){
        for(Student s: std){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }

    public static void averageStd(ArrayList<Student> std){
        Scanner inp=new Scanner(System.in);
        System.out.println("Enter the name of student to see average of it:");
        String name=inp.nextLine();
        Student selectedStd= Student.getStdObjByName(name,std);
        double average= selectedStd.averageGradeTest();
        System.out.println("Average grade of "+selectedStd.getName()+" is: "+average);
    }
    public static void classAverage(ArrayList<Student>  std){
        int sum=0;
        double average=0;
        for (Student s:std){
            sum+=s.averageGradeTest();
        }
        average=sum/std.size();
        System.out.println("Average of class for all tests is : "+average);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double averageGradeTest() {
        int count=testList.size();
        double sum=0;
        for(int i=0;i<count;i++){
            sum+=testList.get(i).grade;
        }
        return sum/count;
    }

    public void loginGradeTest(int id,int gradeTest) {
        Test test=new Test(id,"test"+id);
        test.grade=gradeTest;
        this.testList.add(test);
    }


}
