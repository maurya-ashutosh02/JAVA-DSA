
import java.util.*;
public class prifixsum {

    public static void maxsum(int number[]){

        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;
        int prifix[]=new int[number.length];

        prifix[0]=number[0];


        //calculate prifix array

        for(int i=1;i<prifix.length;i++){
            prifix[i]=prifix[i-1]+ number[i];
        }






        for (int i=0;i<number.length;i++){
            int start=i;
            for(int j=i;j<number.length;j++){
                int end=j;
                currentSum=start==0 ? prifix[end]: prifix[end]-prifix[start-1];

               
                System.out.println(currentSum);



                if(maxSum<currentSum){
                    maxSum=currentSum;
                }
                
            }
           
        }

        System.out.println("max sum="+ maxSum);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array:");
        int size=sc.nextInt();

        int number[]=new int[size];

        for(int i=0;i<size;i++){
            number[i]=sc.nextInt();
        }
       maxsum(number);

    }
}

    


 