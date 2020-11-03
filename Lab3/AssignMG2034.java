import java.lang.Math;
import java.util.Scanner;

class point{
    int x;
    int y;

    public point(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void printpoint(){
        System.out.println(this.x+" "+this.y);
    }
}

class rectangle{
    point pointone;
    point pointtwo;

    public rectangle(point pt_1,point pt_2){
        this.pointone=pt_1;
        this.pointtwo=pt_2;
    }

    public int getHeight(){
        return Math.abs(pointone.y-pointtwo.y);
    }
    public int getwidth(){
        return Math.abs(pointone.x-pointtwo.x);
    }

    public int getArea(){
            return this.getHeight()*this.getwidth();
    }
    public void printcornerpoints(){
        System.out.print("First Corner Point:");
        pointone.printpoint();
        System.out.print("Second Corner Point:");
        pointtwo.printpoint();
    }
}

class circle{
    double radius,area;

    public circle(double radius){
        this.radius=radius;
    }

    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return Math.PI*this.radius*this.radius;
    }
}

public class AssignMG2034 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        //Question 1: Asking for input of two corner's of rectangle and printing them
        //Give the corner points assuming the sides of rectangle are parallel to the sides of axis
        System.out.println("\n");
        System.out.print("Enter the co-ordinates (x,y) of the first corner:");
        point pt_1=new point(sc.nextInt(),sc.nextInt());
        System.out.print("Enter the co-ordinates (x,y) of the second corner:");
        point pt_2=new point(sc.nextInt(),sc.nextInt());
        System.out.println("\n");
        rectangle r = new rectangle(pt_1,pt_2);
        r.printcornerpoints();
        //question 2: printing the height,width and area of the rectangle formed
        System.out.println("\n");
        System.out.println("Height of given rectangle is "+r.getHeight());
        System.out.println("Width of given rectangle is "+r.getwidth());
        System.out.println("Area of given rectangle is "+r.getArea());
        //question 3: 
        System.out.println("\n");
        circle c = new circle((Math.min(r.getHeight(),r.getwidth()))/2.0);
        System.out.println("Radius of circle with maximum area possible that can be inscribed in the above rectangle is "+c.radius);
        System.out.printf("Area of the circle inscribed in rectangle is %.4f\n",c.getArea());
        System.out.println("");
        sc.close();
    }
}
