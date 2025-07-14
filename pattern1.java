import java.util.*;
public class pattern1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows :");
        int a = sc.nextInt();
        System.out.println("Enter number of columns :");
        int b = sc.nextInt();
        for(int i=0; i<=a;i++){
            for(int j=0 ;j<=b;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    
}
