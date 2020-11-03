import java.util.Arrays;
import java.util.Scanner;

class util_avg_calculator{
    public static double calculate_avg_points(employee_record[] e){
        double a=0;
        for(int i=0;i<e.length;i++)
        a+=e[i].project_points;
        a/=e.length;
        return a;
    }
}

class employee {
    int id;
    String name;
    employee_record[] e;

    public employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
 
    public employee_record[] getE() {
        return e;
    }

    public void setE(employee_record[] e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name  + "\n" + "employee e=" + Arrays.toString(e) + "\n" + "average points =" + util_avg_calculator.calculate_avg_points(e);
    }
}

class employee_record{
    int project_points;
    String project_name;
    public employee_record(String project_name,int project_points){
            this.project_name=project_name;
            this.project_points=project_points;
    }
    

    @Override
    public String toString() {
        return "employee_record [project_name=" + project_name + ", project_points=" + project_points + "]";
    }

    public int getProject_points() {
        return project_points;
    }

    public void setProject_points(int project_points) {
        this.project_points = project_points;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
    
}

public class lab1_employee {
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        employee[] emp=new employee[2];
        for(int _t=0;_t<2;_t+=1){
            System.out.print("Enter employee id and name respectively separated by space:");
            String[] s1=(scan.nextLine()).split("\\s+");
            emp[_t]=new employee(Integer.parseInt(s1[0]),s1[1]);
            System.out.print("Enter number of records:");
            int n = Integer.parseInt(scan.nextLine());
            employee_record[] er=new employee_record[n];
            System.out.println("Enter "+n+" employee records");
            for(int i=0;i<n;i++){   
                System.out.print("Enter project name and project points respectively separated by a space:");
                String ss=scan.nextLine();
                String[] s=ss.split("\\s+");
                er[i]=new employee_record(s[0],Integer.parseInt(s[1]));
            }
            emp[_t].setE(er);
        }
        System.out.println("Employee 1 details:");
        System.out.println(emp[0]);//prints name,id,employee record details and average points of employee
        System.out.println("Employee 2 details:");
        System.out.println(emp[1]);
        scan.close();
    }   
}