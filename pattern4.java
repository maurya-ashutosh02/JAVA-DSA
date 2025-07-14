import java.util.*;
public class pattern4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of rows");
        int a = sc.nextInt();
      
        for(int i=1;i<=a;i++){
            for(int j=1;j<=a-i;j++){
                
                    System.out.print( " ");
                
             
            }
            for( int j=1;j<=i;j++){
                System.out.print( i +" " );
                
            }
            System.out.print("\n");
           

        }
    }
}

