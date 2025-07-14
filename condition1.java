import java.util.*;
public class condition1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the value of button:");
        
        int button = sc.nextInt();
        // System.out.println("Enter the value of b:");
        // int b=sc.nextInt();
        // if(a>b){
        //     System.out.println("a is greater than b");
        // }
        // else if(a<b){
        //     System.out.println("a is less than b");
        // }
        // else {
        //     System.out.println("a is equal to b");
        // }
        switch (button) {
            case 1: 
            System.out.println("Jai shree Ram");
                
                break;
                case 2 :
                System.out.println("Jai shree Krishna");
                break;
        
            default:
            System.out.println("Radhe Radhe");
                break;
        }

        
    }
    
}
