import java.io.*;

public class SuperReducedString {

    public static String superReducedString(String s) {
        StringBuilder ss = new StringBuilder(s);
        for (int i = 1; i < ss.length();i++) {
            if(ss.charAt(i)==ss.charAt(i-1)){
                ss.delete(i-1, i+1);
                i = 0;
            }
        }
        String result = ss.toString();
        if(result.length()==0){
            return "Empty String";
        }else{
            return result;
        }
    }

}

class SuperReducedString_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = SuperReducedString.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
