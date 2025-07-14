
import java.util.*;
public class subArray {

    public static void printsubArray(int number[]){
        for (int i=0;i<number.length;i++){
            int start=i;
            for(int j=i;j<number.length;j++){
                int end=j;

                for(int k=start;k<=end;k++){
                    System.out.print(number[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array:");
        int size=sc.nextInt();

        int number[]=new int[size];

        for(int i=0;i<size;i++){
            number[i]=sc.nextInt();
        }
       printsubArray(number);

    }
}

    

