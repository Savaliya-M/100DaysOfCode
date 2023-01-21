import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class TheCoinChangeProblem {

    public static long getWays(int n, List<Long> c) {
        long[] numCoins = new long[n + 1];
        numCoins[0] = 1;
        for (int i = 0; i < c.size(); i++) {
            for (int j = c.get(i).intValue(); j < numCoins.length; j++) {
                numCoins[j] += numCoins[j - c.get(i).intValue()];
            }
        }
        return numCoins[n];
    }

}

class TheCoinChangeProblem_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ways = TheCoinChangeProblem.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
