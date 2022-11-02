package StringPangramsOrNot;
import java.io.*;
import java.util.Scanner;

class Result {
    public static String pangrams(String s) {
    String result = "pangram";
    String slower = s.toLowerCase();
    String alpha = "abcdefghijklmnopqrstuvwxyz";
    char[] alphaarr = alpha.toCharArray();
    for(char c : alphaarr){
        String ss = String.valueOf(c);
        if(!slower.contains(ss)){
            result = "not pangram";
            return result;
        }
    }
    return result;
    }
}

public class StringPangramsOrNot {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string : ");
        String s = sc.nextLine();

        String result = Result.pangrams(s);
        System.out.println("String is "+result);
    }
}
