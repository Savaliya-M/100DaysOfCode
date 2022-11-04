package Inheritance;
class Arithmetic {
    int add(int a, int b){
        int sum = a+b;
        return sum;
    }
}

class Adder extends Arithmetic{
    void display(){
        System.out.println("The sum is displayed below :");
    }
}

public class Inheritance{
    public static void main(String []args){
        Adder a = new Adder();
        
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());	
        
        System.out.print(a.add(10,32) + " " + a.add(10,3) + " " + a.add(10,10) + "\n");
     }
}