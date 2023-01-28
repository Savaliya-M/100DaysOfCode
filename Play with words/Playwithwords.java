package Playwithwords;

import java.io.*;

public class Playwithwords {

    public static int playWithWords(String s) {
        if (s == null || s.length() < 2)
            return 0;

        int[][] dp = new int[s.length()][s.length()];
        for (int l = 1; l <= s.length(); l++) {
            for (int i = 0; i < s.length() - l + 1; i++) {
                int j = i + l - 1;
                if (l == 1) {
                    dp[i][j] = 1;
                } else if (l == 2 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2;
                } else {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    else
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int k = 0; k < s.length() - 1; k++) {
            max = Math.max(max, dp[0][k] * dp[k + 1][s.length() - 1]);
        }

        return max;
    }

}

class Playwithwords_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Playwithwords.playWithWords(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
