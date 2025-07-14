import java.util.*;

public class pairArray {
    
    public static void print_pair(int number[]){
       
       int total_pair=0;
        for(int i=0;i<number.length;i++){

            int current =number[i];
            for(int j=i+1;j<number.length;j++){

                System.out.println("("+current+","+number[j]+")");

                total_pair++;



            }
            System.out.println();

        }
        System.out.println(total_pair);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array:");
        int size=sc.nextInt();

        int number[]=new int[size];

        for(int i=0;i<size;i++){
            number[i]=sc.nextInt();
        }
        print_pair(number);

    }
}
