import java.io.*;
import java.util.stream.*;

public class TheLove_LetterMystery {
    public static int theLoveLetterMystery(String s) {
        int count = 0;
        for (int i = 0; i < s.length()/2; i++) {
            count += Math.abs(s.charAt(i)-s.charAt(s.length()-i-1));
                    }
                    return count;
    }
}

class TheLove_LetterMystery_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = TheLove_LetterMystery.theLoveLetterMystery(s);

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
