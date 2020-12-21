import java.util.*;

/*
Name:C Bhavesh Kumar
Roll number:S20190010034
Lab exam
*/ 

class TourMaps{
    int n;
    int[][] network;
    void createnetwork(){
        Random rand=new Random();
        this.n=100+rand.nextInt(101);
        //this.n=5;
        network=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                network[i][j]=rand.nextInt(1000000000)%2;
                if(network[i][j]==1){
                    network[i][j]=rand.nextInt(10);
                }
            }
        }
    }
    int getn(){
        return this.n;
    }
    void printnetwork(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(network[i][j]+" ");
            }
            System.out.println("");
        }
    }
}

class City{
    int placeID;
    int popular;
    ArrayList<Float> distances;
    int travels;
    int time;
    Set<Integer>hs=new HashSet<Integer>();
    City(){
        Random rand=new Random();
        int i=10000+rand.nextInt(90000);
        while(hs.contains(i)){
            i=10000+rand.nextInt(90000);
        }
        this.placeID=i;
        hs.add(i);
        this.popular=1+rand.nextInt(9);
        this.travels=1+rand.nextInt(50);
    }
    //method for question 3
    static int find_cities_attraction(City[] c,int m){
        int cnt=0;
        for(City s:c){
            if(s.popular>=m){
                cnt++;
            }
        }
        return cnt;
    }
}


public class EndSem2019034{

    public static boolean isPrime(int x){
        //return true is given number is prime.
        if(x<=1)
            return false;
        if(x<=3)
            return true;
        if(x%2==0 || x%3==0)
            return false;
        for(int i=5;i*i<=x;i+=6){
            if(x%i==0 || x%(i+2)==0){
                return false;
            }
        }
        return true;
    }

    public static void question_1(int[][] a,int m,int n){
        int i,j,cnt=0;
        System.out.println("List of 2*2 matrices with given property are:");
        //loop in rows-1,columns-1 and check for the conditions, each elements is considered as starting diagonal element

        for(i=0;i<m-1;i++){
            for(j=0;j<n-1;j++){
                if(isPrime(a[i][j]) && isPrime(a[i+1][j+1])){
                    if(a[i][j]+a[i+1][j+1]==a[i+1][j]+a[i][j+1]){
                        //if true print array and increase cnt
                        System.out.println(a[i][j]+" "+a[i][j+1]);
                        System.out.println(a[i+1][j]+" "+a[i+1][j+1]);
                        System.out.println("");
                        cnt++;
                    }
                }
            }
        }
        System.out.println("Total number of such matrices are: "+cnt);
    }
    public static void main(String[] args) {
        System.out.println("Question 1:");
        System.out.println("");
        //creating array in question 1.
        int array[][] = {
            {2,7,5,11,7,7,2,17,11,9},
            {4,5,9,83,59,8,3,13,7,5},
            {6,3,7,9,5,7,5,17,23,3},
            {3,4,8,1,11,5,3,9,4,6},
            {1,2,5,13,8,7,5,6,89,7},
            {8,4,3,11,3,2,6,7,41,5},
            {3,97,7,1,4,3,4,5,2,1},
            {5,2,5,28,20,7,9,35,8,7},
            {7,4,3,14,6,5,7,5,3,2}
        };
        int m=9,n=10;
        question_1(array, m, n);
        System.out.println("");
        System.out.println("Question 2:");
        System.out.println("");
        TourMaps tm=new TourMaps();
        tm.createnetwork();
        System.out.println("network created");
        //tm.printnetwork();
        City[] c=new City[tm.n];
        //creating n cities from network created.
        for(int i=0;i<tm.n;i++){
            c[i]=new City();
        }
        //(c) in question 2
        Random rand=new Random();
        m=rand.nextInt(9);
        System.out.println("question 2(c)");
        System.out.println("Number of cities with minimum "+m+" popular attractions are: "+City.find_cities_attraction(c, m));
    }
}