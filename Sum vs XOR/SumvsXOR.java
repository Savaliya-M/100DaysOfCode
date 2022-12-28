import java.io.*;

public class SumvsXOR {
    public static long sumXor(long n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                count++;
            }
            n /= 2;
        }
        return (long) Math.pow(2, count);
    }
}

class SumvsXOR_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = SumvsXOR.sumXor(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
