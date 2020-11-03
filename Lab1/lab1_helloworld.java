import java.util.Scanner;
//make sure to give a name in command line argument,else it wouldnt execute command line helloworld part
public class lab1_helloworld{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        //print doesnt print new line
        System.out.print("Enter your name:");
        String s=scan.nextLine();
        //following code takes input from user and prints <username> helloworld
        System.out.println(s+' '+"HelloWorld!");
        //following code takes the input from command line argument and prints <username> helloworld.
        if(args.length!=0)
        System.out.println(args[0]+' '+"HelloWorld!");
        scan.close();
    }
}