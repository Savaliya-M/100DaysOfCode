import java.io.*;
import java.util.stream.*;

public class FunnyString {
    public static String funnyString(String s) {
        char carr[] = s.toCharArray();
        int arr[] = new int[s.length()-1];
        for (int i = 0; i < carr.length-1; i++) {
            arr[i] = Math.abs((int)carr[i]-(int)carr[i+1]);
        }
        for (int i = 0; i < arr.length/2; i++) {
            if(arr[i]!=arr[arr.length-i-1]){
                return "Not Funny";
            }
        }
        return "Funny";
    }
}

class FunnyString_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = FunnyString.funnyString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
