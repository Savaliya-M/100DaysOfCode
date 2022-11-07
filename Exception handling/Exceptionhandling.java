import java.util.*;

public class Exceptionhandling {
    int curr_balance = 1400;
    void withdraw() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("how much amount you want to withdrawal : ");
        int d_amt = sc.nextInt();
        if(curr_balance < 1500){
            throw new Exception("your current balance is lesser then minimum limit.");
        }else{
            curr_balance -= d_amt;
            System.out.println("your transaction is successfully..");
            System.out.println("your current balance is : "+ curr_balance);
        }
    }
}
class exceptionhandling_exe{
    public static void main(String[] args) throws Exception {
        Exceptionhandling eh = new Exceptionhandling();
        Scanner sc = new Scanner(System.in);
        eh.withdraw();
    }
}