import java.util.*;
import java.lang.*;

/*
Name:C Bhavesh Kumar
Roll number:S20190010034
Assignment Rp03
*/

class Matrix{
    int[][] a;
    Matrix(){
        a=new int[5][20];
    }
    void populate(){
        Random rand=new Random();
        for(int i=0;i<5;i++){
            for(int j=0;j<20;j++){
                a[i][j]=20+rand.nextInt(181);
            }
        }
    }
    void printarray(){
        for(int[] i:a){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println("");
        }
    }

    void sortarray(){
        int cnt=0;
        for(int[] i:a){
            if(cnt%2==0){
                Arrays.sort(i);
            }
            else{
                Arrays.sort(i);                
                int t;
                for(int j=0;j<10;j++){
                    t=i[j];
                    i[j]=i[20-j-1];
                    i[20-j-1]=t;
                }
            }
            cnt++;
        }
    }

    void printlist(){
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int[] i:a){
            for(int j:i){
                if(h.containsKey(j)){
                    int k=h.get(j);
                    k++;
                    h.put(j, k);
                }
                else{
                    h.put(j, 1);
                }
            }
        }
        System.out.println("Printing the unique elements and their frequency");
        System.out.println(h);
    }

    public static void main(String[] args){
        Matrix m=new Matrix();
        //filling with random numbrs
        m.populate();
        //printing the array using iterator
        System.out.println("Array generated is:");
        m.printarray();
        //sorting array
        m.sortarray();
        System.out.println("\n"+"Array after sorting");
        //printing after sorting
        m.printarray();
        System.out.println("");
        m.printlist();
    }
}

class Threader extends Thread{
    int[] a;
    int index;
    Threader(int []a,int ind){
        super();
        this.a=a;
        this.index=ind;
    }
    public void run(){
        Arrays.sort(a,index*2000,index*2000+2000);
    }
}

public class Assign30319034{

    public static void question_2(){
        Random rand=new Random();
        long seed=10034;
        rand.setSeed(seed);
        int n=10000;
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=rand.nextInt(501);
        }
        Threader[] t=new Threader[5];
        for(int i=0;i<5;i++){
            t[i]=new Threader(a, i);
            t[i].start();
        }
        
        //waiting for threads to stop executing

        while(t[0].isAlive() || t[1].isAlive() || t[2].isAlive() || t[3].isAlive() || t[4].isAlive()); 

        //finding the sorted array after threads sort the segments of arrays.

        int i=0,j=2000,k=4000,l=6000,m=8000;
        int main_index=0,min_index=10,min=600;
        int[] sorted=new int[10000];
        while(main_index<10000){
            min_index=100000;
            min=600;
            if(i<2000 && a[i]<min){
                min=a[i];
                min_index=i;
            }
            if(j<4000 && a[j]<min){
                min=a[j];
                min_index=j;
            }
            if(k<6000 && a[k]<min){
                min=a[k];
                min_index=k;
            }
            if(l<8000 && a[l]<min){
                min=a[l];
                min_index=l;
            }
            if(m<10000 && a[m]<min){
                min=a[m];
                min_index=m;
            }
            sorted[main_index]=min;
            main_index++;
            if(min_index==i){
                i++;
            }
            if(min_index==j){
                j++;
            }
            if(min_index==k){
                k++;
            }
            if(min_index==l){
                l++;
            }
            if(min_index==m){
                m++;
            }
        }
        
        
        a=sorted;
        //printing after sorted.
        for(i=0;i<10000;i++){
            System.out.print(a[i]+" ");
        }
    }

    //recursive function used for question 4 part a
    static int paths(int x,int y,int x1,int y1){
        if(x==x1 || y==y1){
            return 1;
        }
        return paths(x+1,y,x1,y1)+paths(x,y+1,x1,y1);
    }

    public static void question_4(){
        Random rand=new Random();
        int k=7+rand.nextInt(3);
        int x=rand.nextInt(3),y=rand.nextInt(3);
        int x1=x+rand.nextInt(k-x+1),y1=y+rand.nextInt(k-y+1);
        System.out.println("Part(a) Number of paths between the two points ("+x+","+y+") and ("+x1+","+y1+") are "+paths(x,y,x1,y1));
        System.out.println("Part(b)");
        x=rand.nextInt(3);y=rand.nextInt(3);
        x1=x+rand.nextInt(k-x+1);y1=y+rand.nextInt(k-y+1);
        int sum=x1-x+y1-y;
        if(sum%2!=0){
            System.out.println("Number of paths between the two points ("+x+","+y+") and ("+x1+","+y1+") are "+paths(x,y,x1,y1));
        }
        else{
            System.out.println("Path length is even");
        }
    }

    public static void main(String[] args) {
        //Question 1:
        System.out.println("Question 1:");
        Matrix.main(args);
        //Question 2:
        System.out.println("\nQuestion 2:Generating an array of size 10000 with number in range [0,500]");
        System.out.println("Printing the array after sorting using threading\n");
        question_2();
        System.out.println("\nQuestion 4:");
        //Question 4:
        question_4();
    }
}