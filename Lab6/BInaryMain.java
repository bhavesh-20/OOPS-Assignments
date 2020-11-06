import java.util.Scanner;

/*
    Name:C Bhavesh Kumar
    Assignment Date:06-11
    Roll number:S20190010034
    
*/

abstract class BinaryOperation{
    int operand1,operand2,result;//variables to store integer values and result of the operations on them.
    abstract void printresult();
    abstract int compute();
}

class AddBinaryOperation extends BinaryOperation{
    AddBinaryOperation(int a,int b){
        this.operand1=a;
        this.operand2=b;
    }
    void printresult(){
        System.out.println("Result of the operation = "+result);
    }
    int compute(){
        result=operand1+operand2;
        return result;
    }
}

class SubBinaryOperation extends BinaryOperation{
    SubBinaryOperation(int a,int b){
        this.operand1=a;
        this.operand2=b;
    }
    void printresult(){
        System.out.println("Result of the operation = "+result);
    }
    int compute(){
        result=operand1-operand2;
        return result;
    }
}

class MulBinaryOperation extends BinaryOperation{
    MulBinaryOperation(int a,int b){
        this.operand1=a;
        this.operand2=b;
    }
    void printresult(){
        System.out.println("Result of the operation = "+result);
    }
    int compute(){
        result=operand1*operand2;
        return result;
    }
}

class DivBinaryOperation extends BinaryOperation{
    DivBinaryOperation(int a,int b){
        this.operand1=a;
        this.operand2=b;
    }
    void printresult(){
        System.out.println("Result of the operation = "+result);
    }
    int compute(){
        if(operand2!=0){
            result=operand1/operand2;
        }
        else{
            System.out.println("Cannot divide,division by zero occurs.");
        }
        return result;
    }
}

class BinaryEquationParser{
    public static BinaryOperation parseBinaryOpString(String binOpString){
        int a=0,b=0;
        int n=binOpString.length();
        boolean found=false;//used to separate the operands from operator
        char c=0;//used to store operator
        BinaryOperation bb;//used to store the instance of the created class based on operator.
        for(int i=0;i<n;i++){
            char s=binOpString.charAt(i);
            if(s=='+' || s=='-' || s=='*' || s=='/'){
                found=true;
                c=s;
                continue;
            }
            if(s>='0' && s<='9'){
                //calculating operands
                if(found==false){
                    a=a*10+(binOpString.charAt(i)-'0');
                }
                else{
                    b=b*10+(binOpString.charAt(i)-'0');
                }
            }
        }
        if(c=='+'){
            bb=new AddBinaryOperation(a,b);
        }
        else if(c=='-'){
            bb=new SubBinaryOperation(a, b);
        }
        else if(c=='*'){
            bb=new MulBinaryOperation(a, b);
        }
        else{
            bb=new DivBinaryOperation(a, b);
        }
        return bb;
    }
}

public class BinaryMain{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the binary equation to solve:");
        String s=sc.nextLine();
        //Storing the instance returned from parser.
        BinaryOperation bb=BinaryEquationParser.parseBinaryOpString(s);
        //computing and printing
        bb.compute();
        bb.printresult();
        sc.close();
    }
}