import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TheMaximumSubarray {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int mse = Integer.MIN_VALUE;
        int msoce = Integer.MIN_VALUE;

        int msopce = 0;
        for (int j = 0; j < arr.size(); j++) {
            int elem = arr.get(j);

            if (msopce < 0) {
                msopce = 0;
            }

            msopce += elem;

            if (msopce > msoce) {
                msoce = msopce;
            }

            if (elem > 0) {
                if (mse < 0) {
                    mse = elem;
                } else {
                    mse += elem;
                }
            } else {
                if (mse < 0) {
                    mse = Math.max(elem, mse);
                }
            }

        }
        List<Integer> ans = new ArrayList<>();
        ans.add(msoce);
        ans.add(mse);
        return ans;
    }

}

class TheMaximumSubarray_exe {
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

                List<Integer> result = TheMaximumSubarray.maxSubarray(arr);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
