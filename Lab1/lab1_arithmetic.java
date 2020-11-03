import java.util.Scanner;

public class lab1_arithmetic{

    public static int Addition(int a,int b){
        return a+b;
    }
    public static int Subtraction(int a,int b)
    {
        return a-b;
    }
    public static int Multiplication(int a,int b){
        return a*b;
    }
    public static int Division(int a,int b){
        if(b!=0)
        return a/b;
        else
        return -1;
    }
    public static int or(int a,int b){
        return a|b;
    }
    public static int and(int a,int b){
        return a&b;
    }
    public static int xor(int a,int b){
        return a^b;
    }

    public static void println(Object line){
        System.out.println(line);
    }
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int choice;
        while(true)
        {
            int a,b;
            println("=================================");
            println("Arithmetic operation Menu");
            println("1.Addition"+"\n"+"2.Subtraction");
            println("3.Multiplication\n"+"4.Division\n"+"5.Binary OR\n"+"6.Binary AND\n"+"7.Binary XOR");
            println("8.Exit");
            println("=================================");
            System.out.print("Enter Your choice:");
            choice=scan.nextInt();
            if(choice==8)
            {
                break;
            }
            else{
                System.out.print("Enter numbers on which operation are to be performed:");
                a=scan.nextInt();
                b=scan.nextInt();
                switch(choice)
                {
                    case 1:println(Addition(a,b));break;
                    case 2:println(Subtraction(a, b));break;
                    case 3:println(Multiplication(a, b));break;
                    case 4:
                        if(Division(a, b)==-1)
                            println("Cannot be divided");
                        else
                            println(Division(a, b));
                        break;
                    case 5:println(and(a, b));break;
                    case 6:println(or(a, b));break;
                    case 7:println(xor(a, b));break;
                    default:println("Inavlid choice");
                }
            }
        }
        scan.close();
    }
}