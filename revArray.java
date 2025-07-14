
import java.util.*;
public class revArray {

    public static void reverse(int number[]){
        int first=0;
        int last=number.length-1;
        while(first<last){
            //swap
            int temp=number[last];
            number[last]=number[first];
            number[first]=temp;

            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of array:");

        int size =sc.nextInt();
        int  number []=new int [size];

        for (int i=0;i<size;i++){
          number[i]=sc.nextInt();
        }
        reverse(number);
        for(int i=0;i<size;i++){
            System.out.print(number[i]+" ");
        }
        System.out.println();
    }
    
}
