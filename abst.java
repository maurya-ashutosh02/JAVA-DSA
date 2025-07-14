abstract class animal{
   abstract void walk();

    }

class horse extends animal{
    public void walk(){
        System.out.println(" walk on four legs");
    }
}

class chicken extends animal{
    public void walk(){
        System.out.println("walk on two legs");

    }
}

public class abst {
    public static void main(String[] args) {
    
        horse Horse = new horse();
        Horse.walk();
       // animal Animal=new animal();
       // Animal.walk();
    }
    
}
