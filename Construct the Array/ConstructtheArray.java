import java.io.*;

public class ConstructtheArray {

    public static long countArray(int n, int k, int x) {
        long mod = 1000000007;
        long[] a = new long[n];
        long[] b = new long[n];
        a[0] = x == 1 ? 1 : 0;
        b[0] = x == 1 ? 0 : 1;
        for (int i = 1; i < n; i++) {
            a[i] = b[i - 1] % mod;
            b[i] = (a[i - 1] * (k - 1) + b[i - 1] * (k - 2)) % mod;
        }
        return a[n - 1];
    }

}

class ConstructtheArray_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        int x = Integer.parseInt(firstMultipleInput[2]);

        long answer = ConstructtheArray.countArray(n, k, x);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
