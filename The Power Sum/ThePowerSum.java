import java.io.*;

public class ThePowerSum {

    public static int powerSum(int X, int N) {
        return helper(X, N, 1);
    }

    static int helper(int x, int n, int p) {
        int res = x - (int) Math.pow(p, n);

        if (res == 0) {
            return 1;
        }
        if (res < 0) {
            return 0;
        }
        return helper(res, n, p + 1) + helper(x, n, p + 1);
    }
}

class ThePowerSum_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int result = ThePowerSum.powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
