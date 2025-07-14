
import java.util.*;
public class maxsubarraySum {

    public static void maxsum(int number[]){

        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;
        for (int i=0;i<number.length;i++){
            int start=i;
            for(int j=i;j<number.length;j++){
                int end=j;
                currentSum=0;

                for(int k=start;k<=end;k++){
                    //subArry sum

                    currentSum+=number[k];
                }
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

    

