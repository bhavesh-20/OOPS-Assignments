import java.util.Scanner;

/*
    Name:C Bhavesh Kumar
    Assignment Date:06-11
    Roll number:S20190010034

*/

abstract class VariableArityOperation{
    int[] list; //list used for storing operands.
    int result; //variable to store result of operation.
    abstract void printresult();
    abstract int compute();
}

class AddVariableArityOperation extends VariableArityOperation{
    AddVariableArityOperation(int[] a){
        this.list=a;
    }
    void printresult(){
        System.out.println("Result of operation = "+result);
    }
    int compute(){
        //Computing the result
        int n=list.length;
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=list[i];
        }
        result=ans;
        return result;
    }
}

class SubVariableArityOperation extends VariableArityOperation{
    SubVariableArityOperation(int[] a){
        this.list=a;
    }
    void printresult(){
        System.out.println("Result of operation = "+result);
    }
    int compute(){
        //Computing the result
        int n=list.length;
        int ans=list[0];
        for(int i=1;i<n;i++){
            ans-=list[i];
        }
        result=ans;
        return result;
    }
}

class MulVariableArityOperation extends VariableArityOperation{
    MulVariableArityOperation(int[] a){
        this.list=a;
    }
    void printresult(){
        System.out.println("Result of operation = "+result);
    }
    int compute(){
        //Computing the result
        int n=list.length;
        int ans=1;
        for(int i=0;i<n;i++){
            ans*=list[i];
        }
        result=ans;
        return result;
    }
}

class DivVariableArityOperation extends VariableArityOperation{
    DivVariableArityOperation(int[] a){
        this.list=a;
    }
    void printresult(){
        System.out.println("Result of operation = "+result);
    }
    int compute(){
        //Computing the result
        int n=list.length;
        int ans=list[0];
        for(int i=1;i<n;i++){
            if(list[i]==0){
                System.out.println("Division by zero occurs,cannot divide");
                return result;
            }
            ans/=list[i];
        }
        result=ans;
        return result;
    }
}

class VariableArityEquationparser{
    public static VariableArityOperation parseVariableArityString(String varOpString){
        int cnt=0;//used to count the number of operators to initialize an array for operands
        //number of operands=number of operators+1
        for(int i=0;i<varOpString.length();i++){
            if(varOpString.charAt(i)=='+' || varOpString.charAt(i)=='-' || varOpString.charAt(i)=='*' || varOpString.charAt(i)=='/')
            cnt++;
        }
        cnt++;//number of operands
        int[] a=new int[cnt];//array for operands
        for(int i=0;i<cnt;i++){
            a[i]=0;
        }
        int k=0,i;//variable k is used for calculating operands values,i for parsing string.
        char c=0;//used to store operator.
        VariableArityOperation vv;
        for(i=0;i<varOpString.length();i++){
            char s=varOpString.charAt(i);
            if(s=='+' || s=='-' || s=='*' || s=='/'){
                k++;//go to new operand
                c=s;
                continue;
            }
            if(s>='0' && s<='9')
                a[k]=a[k]*10+(s-'0');//calculating operand value,from string.
        }
        //creating instance based on operator
        if(c=='+'){
            vv=new AddVariableArityOperation(a);
        }
        else if(c=='-'){
            vv=new SubVariableArityOperation(a);
        }
        else if(c=='*'){
            vv=new MulVariableArityOperation(a);
        }
        else{
            vv=new DivVariableArityOperation(a);
        }
        return vv;
    }
}

public class VariableArityMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Binary equation to solve:");
        String s=sc.nextLine();
        //variable to store the instance returned from parser.
        VariableArityOperation vv=VariableArityEquationparser.parseVariableArityString(s);
        //computing and printing the result.
        vv.compute();
        vv.printresult();
        sc.close();
    }
}
