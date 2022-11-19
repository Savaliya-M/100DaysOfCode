import java.io.*;
import java.util.stream.*;

public class Palindrome_Index {
    public static int palindromeIndex(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                if(i+1 < s.length()){
                    boolean ispaindrom = palindromcheck(s.substring(i+1,s.length()-i));
                    if(ispaindrom){
                        return i;
                    }else{
                        return s.length()-i-1;
                    }
                }
            }
        }
        return -1;
    }
    
    static boolean palindromcheck(String str){
        for (int i = 0; i < str.length()/2 ; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

}

class Palindrome_Index_Exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Palindrome_Index.palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}