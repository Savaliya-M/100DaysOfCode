import java.io.*;
import java.util.stream.*;

public class Abbreviation {

    public static String abbreviation(String a, String b) {
        if (a.length() < b.length()) {
            return "NO";
        }

        boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (j > i) {
                    dp[i][j] = false;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (j == 0) {
                    dp[i][j] = !Character.isUpperCase(a.charAt(i - 1)) && dp[i - 1][j];
                } else if (Character.isUpperCase(a.charAt(i - 1))) {
                    boolean tmp = a.charAt(i - 1) == b.charAt(j - 1) && dp[i - 1][j - 1];
                    dp[i][j] = tmp;
                } else {
                    boolean tmp = (Character.toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1)) && dp[i - 1][j - 1];
                    boolean tmp2 = (tmp || dp[i - 1][j]);
                    dp[i][j] = tmp2;
                }
            }
        }

        return dp[a.length()][b.length()] ? "YES" : "NO";
    }

}

class Abbreviation_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String a = bufferedReader.readLine();

                String b = bufferedReader.readLine();

                String result = Abbreviation.abbreviation(a, b);

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
