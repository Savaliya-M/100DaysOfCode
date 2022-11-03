import java.io.*;
import java.util.*;


class Result {
     String twoStrings(String s1, String s2) {
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        int a = s1.length();
        int b = s2.length();
        String result = "";
        
        if(a>b){
            for (int i = 0; i < b; i++) {
                for (int j = 0; j < a; j++) {
                    if(s1arr[j] == s2arr[i]){
                        result = "YES";
                        return result;
                    }else{
                        result = "NO";
                    }
                }
            }
        }else{
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    if(s2arr[j] == s1arr[i]){
                        result = "YES";
                        return result;
                    }else{
                        result = "NO";
                    } 
                }
            }
        }
        return result;
    }

}

public class compareString {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        Result r1 = new Result();
        System.out.print("Enter the string 1 : ");
        String S1 = sc.nextLine();
        System.out.print("Enter the string 2 : ");
        String S2 = sc.nextLine();
        String result = r1.twoStrings(S1 ,S2);
        System.out.println("Result = " + result);
    }
}
