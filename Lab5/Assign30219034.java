import java.util.Random;

interface interestcalc{
    float interestRates(int months,float rateof_interest,int typeof_interest);
    float getMaturityAmount(int months,float rateof_interest,int typeof_interest);
}

interface question_4{
    public void example();
}

class circle{
    //radius of float type
    float radius;
    //center of type point,which is an inner class
    point p;

    class point{
        int x,y;
        point(int u,int v){
            this.x=u;
            this.y=v;
        }
        //method to print point
        void getPoint(){
            System.out.println("circle center = "+ "(" + x + " " + y + ")");
        }
    }

    circle(){

    }

    circle(point p,float r){
        this.p=p;
        this.radius=radius;
    }

    void printcircle(){
        p.getPoint();
        System.out.println("Radius = "+this.radius);
    }

    public static void main(){
        Random rand = new Random();
        int x,y;
        float r;
        //allocating memory for 10 circles.
        circle[] c = new circle[10];
        //generating 10 random circles
        for(int i=0;i<10;i++){
            x=11+rand.nextInt(59);
            y=11+rand.nextInt(59);
            c[i] = new circle();
            circle.point p = c[i].new point(x,y);
            c[i].p=p;
            int l1,l2,l3,l4;
            l1=x-10;
            l2=70-x;
            l3=y-10;
            l4=70-y;
            int min=Math.min(l1,l2);
            min=Math.min(min,l3);
            min=Math.min(min,l4);
            r=rand.nextFloat();
            if(min>0){
                r+=rand.nextInt(min);
            }
            c[i].radius=r;
        }
        //Printing the generated circles.
        for(int i=0;i<10;i++){
            c[i].printcircle();
        }
    }
}

class Factors{
    public void ComputePrimeFactors(int k){
        while(k%2==0){
            printFactors(2);
            k/=2;
        }
        for(int i=3;i<=Math.sqrt(k);i+=2){
            while(k%i==0){
                printFactors(i);
                k/=i;
            }
        }
        if(k>2)
            printFactors(k);
        System.out.println("");
    }
    public void printFactors(int i){
        System.out.print(i+" ");
    }
    public int EvenFactors(int num){
        int cnt=0;
        while(num%2==0){
            num/=2;
            cnt++;
        }
        int r=2,sum=0;
        for(int i=0;i<cnt;i++){
            System.out.print(r+" ");
            sum+=r;
            r*=2;
        }
        return sum;
    }
    public void checkCommonFactors(int[] a){
        int counter=0;
        int n=a.length,i,j,m=0;
        boolean check=false;
        for(i=0;i<n;i++){
            m=Math.max(m,a[i]);
        }
        i=2;
        for(j=0;j<n;j++){
            while(a[j]%i==0){
                a[j]/=2;
                check=true;
            }
            if(check) counter++;
        }
        if(counter==n){
            System.out.print("2 ");
        }
        for(i=3;i<Math.sqrt(m);i+=2){
            counter=0;
            check=false;
            for(j=0;j<n;j++){
                while(a[j]%i==0){
                    a[j]/=i;
                    check=true;
                }
                if(check) counter++;
            }
            if(counter==n)  System.out.print(i+" "); 
        }
    } 
}

class question_3 implements interestcalc{
    float pri;
    public float interestRates(int month,float rateof_interest,int typeof_interest){
        if(typeof_interest!=1){
            return pri*((float)month/12)*rateof_interest/100f;
        }
        else{
            float interest=pri;
            for(int i=0;i<month;i++){
                interest=interest+(interest*rateof_interest)/100f;
            }
            return interest;
        }
    }
    public float getMaturityAmount(int month,float rateof_interest,int typeof_interest){
        if(typeof_interest!=1){
            return pri+interestRates(month, rateof_interest, typeof_interest);
        }
        else{
            return pri+pri*(float)Math.pow(1+rateof_interest/100f,month);
        }
    }
    public static void main(){
        Random rand=new Random();
        question_3 q = new question_3();
        q.pri=rand.nextInt(100000);
        System.out.println("interest rate for "+ q.pri + " in state bank of india with simple interest is :" + (float)q.interestRates(12, 5.17f, 0));
        System.out.println("interest rate for "+ q.pri + " in state bank of india with compound interest is :" + (float)q.interestRates(12, 5.17f, 1));
        System.out.println("interest rate for "+q.pri + " in punjab national bank with compound interest is :" + (float)q.interestRates(24, 5.62f, 1));
        System.out.println("interest rate for "+q.pri + " in indian bank with simple interest is :" + (float)q.interestRates(18, 5.35f, 0));
        System.out.println("");
        System.out.println("Maturity amount for "+ q.pri + " in state bank of india with simple interest is :" + (float)q.getMaturityAmount(12, 5.17f,0));
        System.out.println("Maturity amount for "+ q.pri + " in state bank of india with compound interest is :" + (float)q.getMaturityAmount(12, 5.17f,1));
        System.out.println("Maturity amount for "+ q.pri + " in punjab national bank with compound interest is :" + (float)q.getMaturityAmount(24, 5.62f,1));
        System.out.println("Maturity amount for "+ q.pri + " in indian bank with simple interest is :" + (float)q.getMaturityAmount(18, 5.35f,0));
    }
}

class Computer{
    int x=10;
    class CPU{
        CPU(){
            System.out.println("Inside member inner class");
            System.out.println("x = "+x);
            System.out.println("");
        }
    }
    static class RAM{
        RAM(){
            System.out.println("Inside static inner class");
            System.out.println("");
            //cannot access x as the class is static
        }
    }
    class Mouse implements question_4{
        public void example(){

        }
    }
    public void input_output(){
        int x=20;
        class Moniter{
            Moniter(){
                System.out.println("Inside local inner class");
                System.out.println("x = "+x);
                System.out.println("");
            }
        }
        Moniter m = new Moniter();
        Mouse mo = new Mouse(){
            public void example(){
                System.out.println("Inside anonymous inner class");
            }
        };
        mo.example();
    }

    public static void main(){
        Computer c =new Computer();
        Computer.CPU cp = c.new CPU();
        Computer.RAM r = new Computer.RAM();
        c.input_output();
    }
}

public class Assign30219034 {
    public static void main(String[] args){
        Random rand=new Random();
        //Question 1: Generating 10 random circles using point as an inner class.
        //code written in class circle.
        //program executed in main method of circle class.
        circle.main();        
        //Question 2:
        Factors f=new Factors();
        //generating random input
        int k=2+rand.nextInt(1000);
        //Question 2 part 1:
        System.out.print("\nPrime factors of "+k+":");
        f.ComputePrimeFactors(k);
        //Question 2 part 2:
        System.out.print("\nEven factors of "+k+":");
        int sum=f.EvenFactors(k);
        System.out.println("\nSum of even factors = "+ sum);
        //Question 2 part 3:
        int[] num=new int[20];
        //generating and printing array
        System.out.print("\nArray generated is:");
        for(int i=0;i<num.length;i++){
            int r=20+rand.nextInt(130);
            if(r%2==0){
                num[i]=r;
            }
            else{
                if(r+1<=150) num[i]=r+1;
                else num[i]=r-1;
            }
            System.out.print(num[i]+" ");
        }
        //printing the common factors of the array
        System.out.print("\nCommon factors of the array are:");
        f.checkCommonFactors(num);
        System.out.println("");
        //Question 3:
        System.out.println("");
        question_3.main();
        System.out.println("");
        //Question 4:
        Computer.main();
    }    
}
