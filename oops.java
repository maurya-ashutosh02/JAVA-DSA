public class oops {
    public static void main(String [] args){
        Pen p1 = new Pen();  
        p1.setcolor("blue");
        System.out.println(p1.color);
        p1.setTip(6);
        System.out.println(p1.tip);
        
        BankAccount myAcc=new BankAccount();
        myAcc.Username="ASHUTOSH MAURYA";
        myAcc.setPassword("abdhfhj");
    }
    
}
class Pen{
    //properties

    String color ;
    int tip;

    void setcolor(String newColor){
        color=newColor;
    }
    void setTip(int newTip){
        tip=newTip;
    }

}


class Student{
    String name;
    int age;
    float percentage;

    void calpercentage(int phy,int che,int maths){
        percentage=(phy+che+maths)/3;
    }
     
}
//Access Modifier;
class BankAccount{

   public String Username;
   private String password;

   public  void setPassword(String pwd){
    password=pwd; 
   }



  

}