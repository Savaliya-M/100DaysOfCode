package countWordsFromCamelcaseString;

import java.util.Scanner;

public class countWordsFromCamelcaseString {
    public static int camelcase(String s) {
        char[] ch = s.toCharArray();
        int count = 0;
        for(int i = 0; i < s.length();i++){
            if(Character.isUpperCase(ch[i])){
                count++;
            }
        }
        return count+1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the camel case string : ");
        String s = sc.nextLine();
        int result = camelcase(s);
        System.out.println("word in a string = "+ result);
    }
}
