import java.util.*;
public class inbuildExceptionHandling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        try{
            System.out.println("enter x :");
            x = sc.nextInt();
            System.out.println("enter y :");
            y = sc.nextInt();
            try{
            int div = x/y;             
            System.out.println(div);               
            }
            catch(ArithmeticException e){
                System.out.println(e);
            }
        }
        catch(InputMismatchException e){
        System.out.println(e);
    }
    }
}
