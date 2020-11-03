import java.util.*;


class Pascaltriangle{
    int[][] a=new int[100][100];
    int n;
    Pascaltriangle(int n){
        this.n=n;
    }
    void createPascal(){
        int i,j;
        for(i=0;i<n;i++){
            for(j=0;j<=i;j++){
                if(i==j || j==0) a[i][j]=1;
                else{
                    a[i][j]=a[i-1][j]+a[i-1][j-1];
                }
            }
        }
    }
    void printPascal(){
        for(int i=0;i<this.n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
    void printfibonacci(){
        int[] f=new int[this.n];
        for(int i=0;i<this.n;i++){
            f[i]=0;
        }
        for(int i=0;i<this.n;i++){
            for(int j=0;j<=i;j++){
                if(i+j<n) f[i+j]+=a[i][j];
            }
        }
        for(int i=0;i<n;i++) System.out.print(f[i]+" ");
        System.out.print("\n");
    }
}

class Point{
    int x,y;
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class Line{
    Point a,b;
    double linewidth;
    int color; /* 1-5 */
    Line(){

    }

    void setpointa(Point a,Point b){
        this.a = a;
        this.b = b;
        this.linewidth = Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
    }

    Line(Point a,Point b){
        this.a=a;
        this.b=b;
        this.linewidth = Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
    }
    void print_endpoints(){
        System.out.println("End points are :" + "(" + a.x +"," + a.y + ")" + "(" + b.x +"," + b.y + ")" );
    }

    void print_linewidth(){
        System.out.println("Line width is:"+this.linewidth);
    }
}

class Rectangle{
    double length;
    double width;
    Line a,b,c,d;

    Rectangle(){
        
    }

    Rectangle(Line a,Line b,Line c,Line d){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.length=a.linewidth;
        this.width=b.linewidth;
    }

    double perimeter(double length,double width){
        return 2*(length+width);
    }

    double area(double length,double width){
        return length*width;
    }
}

class Square extends Rectangle{
    double sidelength;
    Line a,b,c,d;
    Square(Line a,Line b,Line c,Line d){
        //super(a, b, c, d);
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.sidelength=a.linewidth;
    }

    double perimeter(double length){
        return super.perimeter(length, length);
    }
    double area(double length){
        return super.area(length, length);
    }
}


class SortNumbers{
    static void separate_prime(int[][] a){
        int m=10;
        int i,pt_1=0,pt_2=0;
        while(pt_1<m && pt_2<m){
            if(pt_1>=10 || pt_2>=10) break;
            while(!isprime(a[0][pt_1]) && pt_1<m) pt_1++;
            while(isprime(a[1][pt_2]) && pt_2<m) pt_2++;
            if(pt_1>=10 || pt_2>=10) break;
                i=a[0][pt_1];
                a[0][pt_1]=a[1][pt_2];
                a[1][pt_2]=i;
                pt_1++;
                pt_2++;
        }
    }
    static boolean isprime(int n){
        int i;
        for(i=2;i<=(int)Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    static void sort_it(int[][] a){
        int m=10;
        for(int i=0;i<m;i++){
            for(int j=0;j<m-1;j++){
                if(a[0][j]>a[0][j+1]){
                    int temp=a[0][j];
                    a[0][j]=a[0][j+1];
                    a[0][j+1]=temp;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m-1;j++){
                if(a[1][j]<a[1][j+1]){
                    int temp=a[1][j];
                    a[1][j]=a[1][j+1];
                    a[1][j+1]=temp;
                }
            }
        }
    }
}

public class Assign0519034 {

    static void recursive_fill(double[] a,Random rand,int n,int i){
        if(i>=n) return;
        a[i]=rand.nextInt(100)+rand.nextDouble();
        recursive_fill(a, rand, n, i+1);
    }

    static void recursive_print(double[] a,int n,int i){
        if(i>0) recursive_print(a, n, i-1);
        System.out.print(a[i]+" ");
    }

    static double return_avg(double[] a,int n){
        int i;
        double sum=0;
        for(i=0;i<n;i++)sum+=a[i];
        return sum/n;
    }

    static void recursive_find(double[] a,int n,int i,double avg){
        if(i>=n) return;
        if(a[i]+a[i-1]<avg) System.out.println(a[i]+" "+a[i-1]);
        recursive_find(a, n, i+1, avg);
    }

    static boolean check_rect_sqr(Point[] p){
        Line A,B,C,D;
        A = new Line(p[0],p[1]);
        B = new Line(p[1],p[2]);
        C = new Line(p[2],p[3]);
        D = new Line(p[3],p[1]);
        if(A.linewidth==C.linewidth && B.linewidth==D.linewidth) return true;
        return false;
    }
    public static void main(String[] args){
        Random rand=new Random();
        Scanner sc = new Scanner(System.in);
        /*                                      Question 1                                  */
        int n=20+rand.nextInt(31); // n is in [40,50] inclusive
        double[] a= new double[n];
        //1(a)
        recursive_fill(a,rand,n,0);
        //1(b)
        System.out.println("Printing the randomly generated array:");
        recursive_print(a,n,n-1);
        double avg=return_avg(a,n);
        System.out.println("");
        //1(c)
        System.out.println("Printing the consecutive pairs which have sum greater than average:");
        recursive_find(a,n,1,avg);
        /*                                       Question 2                               */
        System.out.print("Enter the number of rows in pascal triangle:");
        int k=sc.nextInt();
        Pascaltriangle p= new Pascaltriangle(k);
        p.createPascal();
        System.out.println("Printing the Pascal triangle for given number of rows:");
        p.printPascal();
        System.out.println("Printing the fibonacci numbers generated from the pascal triangle:");
        p.printfibonacci();
        /*                                       Question 3                                */ 
        Line linesegment = new Line(new Point(rand.nextInt(51),rand.nextInt(51)),new Point(rand.nextInt(51),rand.nextInt(51)));
        System.out.println("Random line segment generated:");
        linesegment.print_endpoints();
        linesegment.print_linewidth();
        Point[] po = new Point[4];
        po[0] = new Point(rand.nextInt(51),rand.nextInt(51));    
        po[1] = new Point(rand.nextInt(51),rand.nextInt(51));
        po[2] = new Point(rand.nextInt(51),rand.nextInt(51));
        po[3] = new Point(rand.nextInt(51),rand.nextInt(51));
        System.out.println("Generated points are:");
        for(int i=0;i<4;i++){
            System.out.println("(" + po[i].x + "," + po[i].y + ")");
        }
        boolean check=check_rect_sqr(po);
        if(!check) System.out.println("The Generated points cannot form a rectangle or square.");
        else System.out.println("The Generated points form either a rectangle or square");

        /* Changing values to make it a square and rectangle*/

        po[1].x=po[0].x;
        po[1].y=po[0].y+1;
        po[2].y=po[0].y;
        po[2].x=po[0].x+1;
        po[3].x=po[0].x+1;
        po[3].y=po[0].y+1;

        System.out.println("New points are:");
        for(int i=0;i<4;i++){
            System.out.println("(" + po[i].x + "," + po[i].y + ")");
        }

        Rectangle r = new Rectangle(new Line(po[0],po[1]),new Line(po[0],po[2]),new Line(po[2],po[3]),new Line(po[3],po[1]));
        Square s = new Square(new Line(po[0],po[1]),new Line(po[0],po[2]),new Line(po[2],po[3]),new Line(po[3],po[1]));

        System.out.println("Perimeter of the rectangle made is "+ r.perimeter(r.length,r.width));
        System.out.println("Area of rectangle is "+ r.area(r.length, r.width));

        System.out.println("Perimeter of the square is "+ s.perimeter(s.sidelength));
        System.out.println("Area of the square is "+s.area(s.sidelength));

        /*                                       Question 4*                               */
        int[][] x = new int[2][10];
        int i,j;
        System.out.println("Enter the values in 2*10 array:");
        for(i=0;i<2;i++){
            for(j=0;j<10;j++) x[i][j]=sc.nextInt();
        }
        SortNumbers.separate_prime(x);
        System.out.println("Printing array after separating the prime and non-prime:");
        for(i=0;i<2;i++){
            for(j=0;j<10;j++) System.out.print(x[i][j]+" ");
            System.out.print("\n");
        }
        System.out.println("Printing array after sorting prime and non-prime accordingly:");
        SortNumbers.sort_it(x);
        for(i=0;i<2;i++){
            for(j=0;j<10;j++) System.out.print(x[i][j]+" ");
            System.out.print("\n");
        }
        sc.close();
    }
}