/*
*NAME : C Bhavesh Kumar
*Rollno. : S20190010034
*Assignment : ASSIGNMG3
*/


//Base class student
class student{
    private String sname;
    public student(String name){   //constructor defined
        this.sname=name;
    }
    public String getname(){    //method getter
        return this.sname;
    }
}

class OOP2020_student extends student{
    private int[] exams;//variable of type int[] to store the grade of exams
    private int num_exams;//variable to store the size of exams array
    public OOP2020_student(String sname,int num_exams){
        super(sname);//super constructor called.
        this.num_exams=num_exams;
        exams=new int[num_exams+1];// +1 for getting index number num_exams..range is from 1 to num_exams(inclusive)
    }
    public boolean saveGrade(int ind_exam,int grade){
        if(ind_exam<=0 || ind_exam>this.num_exams){//Since range is 1 to 20 inclusive.
            return false;
        }
        this.exams[ind_exam]=grade;
        return true;
    }
    public int getGrade(int ind_exam){
        if(ind_exam<=0 || ind_exam>this.num_exams){//since range is 1 to 20 inclusive
            return -1;
        }
        return this.exams[ind_exam];
    }
    public String getName(){//Super method used.inherited from parent.
        return super.getname();
    }
}

class OOP2020_course{
    private static int capacity,enrolled=0;//Class variables - capacity contains the capacity of number of students in course and enrolled contains number of enrolled students in the course.For each student added enrolled is increased by 1
    private OOP2020_student[] students;//Array to hold student information.
    public OOP2020_course(int capacity){//constructor defined
        this.capacity=capacity;
        students = new OOP2020_student[capacity];
    }
    public boolean addStudent(String name,int num_exams){
        if(this.enrolled>=capacity){//if student cannot be added since the capacity is completely filled returns false
            return false;
        }
        students[this.enrolled]=new OOP2020_student(name, num_exams);
        this.enrolled++;
        return true;
    }
    public OOP2020_student findStudent(String name){//linear search
        for(int i=0;i<enrolled;i++){
            if(name.equals(students[i].getName())){
                return students[i];
            }
        }
        return null; //returns null if not found
    }
    public double findAverage(int ind_exam){
        double average=0;
        for(int i=0;i<enrolled;i++){
            average+=students[i].getGrade(ind_exam);
        }
        if(enrolled==0){//checking division by zero
            System.out.println("Zero division:Number of enrolled students are 0");
            return -1;
        }
        return average/enrolled;
    }
    public static void main(String[] args){
        OOP2020_course a=new OOP2020_course(20);
        a.addStudent("Nikhil Sharma", 3);
        a.addStudent("Pratyush Lahiri", 3);
        OOP2020_student temp = a.findStudent("Nikhil Sharma");
        if(temp!=null)
            temp.saveGrade(1, 80);
        temp=a.findStudent("Pratyush Lahiri");
        if(temp!=null)
            temp.saveGrade(1, 70); 
        System.out.println("Input:");
        System.out.println("Student Name:Nikhil Sharma" +"\n" + "Grade in exam 1: 80");
        System.out.println("Student Name:Pratyush Lahiri" +"\n" + "Grade in exam 1: 70");
        double ans=a.findAverage(1);
        if(ans!=-1)
        {
            System.out.println("Output:");
            System.out.println("Average of the class on exam 1 is "+ans); 
        }
    }
}

public class S20190010034_ASSIGNMG3{
    public static void main(String[] args){
        OOP2020_course.main(args);
    }
}