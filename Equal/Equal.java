package Equal;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import java.util.Arrays;

public class Equal {

    public static int equal(List<Integer> arr) {
        int[] possibilities = new int[5];

        int minimum = Collections.min(arr);

        for (int i = 0; i < possibilities.length; i++) {

            for (int k : arr) {
                int diff = k - minimum;
                int stepsRequired = diff / 5 + (diff % 5) / 2 + ((diff % 5) % 2) / 1;
                possibilities[i] += stepsRequired;
            }
            minimum--;
        }

        return Arrays.stream(possibilities).min().getAsInt();
    }

}

class Equal_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                int result = Equal.equal(arr);

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
