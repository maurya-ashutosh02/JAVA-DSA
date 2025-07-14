import java.util.*;
public class pattern3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of rows");
        int a = sc.nextInt();
        System.out.print("Enter no. columns :");
        int b= sc.nextInt();
        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                if(i==j||i>=j){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                
            }
            System.out.print("\n");
        }
    }
    
    
}
