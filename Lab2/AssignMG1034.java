// Please enter firstname and lastname of the students in commandline separated by space.
//please enter the details mentioned above for 15 students.
import java.util.Random;

class student{
    String firstname;
    String lastname;
    double marks;
    char section;
    Random rand = new Random();
    public student(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void generatemarks(){
        this.marks=rand.nextInt(100)+rand.nextDouble();
    }
    public void print_name_marks(){
        System.out.format("%-20s%-20s%-20f%-20c\n",this.firstname,this.lastname,this.marks,this.section);
    }
    public static void sort(student[] s){
        student temp;
        int n=s.length;
        int i,j;
        for(i=0;i<n;i++){
            for(j=0;j<n-i-1;j++){
                if(s[j].marks<s[j+1].marks){
                    temp=s[j];
                    s[j]=s[j+1];
                    s[j+1]=temp;
                }
            }
        }
    }
    public void set_section(int i){
        if(i%3==0)
            this.section='A';
        else if(i%3==1)
            this.section='B';
        else
            this.section='C';
    }
    public void print(){
        System.out.format("%-20s%-20s%-20f%-20c\n",this.firstname,this.lastname,this.marks,this.section);
    }
}

public class AssignMG1034 {
    public static void main(String[] args){
        if(args.length==0){
            System.out.println("Please give input through command line, Firstname and Lastname of each student separated by space");
            System.exit(0);
        }
        //Question 1: taking input from command line arguments and creating object
        int i,n;
        n=(args.length)/2;
        student[] s = new student[n];
        //generating marks
        for(i=0;i<n;i++){
            s[i]=new student(args[2*i], args[2*i+1]);
            s[i].generatemarks();
        }
        System.out.format("%-20s%-20s%-20s\n\n","FirstName","LastName","Marks");
        for(i=0;i<n;i++)
        s[i].print_name_marks();
        //Question 2:sorting the array of objects based on marks
        student.sort(s);
        System.out.println("");
        //Question 3: Generating sections and printing student details
        System.out.format("%-20s%-20s%-20s%-20s\n\n","FirstName","LastName","Marks","Section");
        for(i=0;i<n;i++){
            s[i].set_section(i);
            s[i].print();
        }
    }
}
