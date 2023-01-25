import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class StockMaximize {

    public static long stockmax(List<Integer> prices) {
        int n = prices.size();
        int[] dp = new int[n];
        int max = prices.get(n - 1);
        for (int i = n - 1; i >= 0; i--) {
            max = (prices.get(i) > max) ? prices.get(i) : max;
            dp[i] = max;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (dp[i] - prices.get(i));
        }
        return sum;
    }

}

class StockMaximize_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                long result = StockMaximize.stockmax(prices);

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
