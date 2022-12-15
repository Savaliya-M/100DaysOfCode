import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class MinimumAbsoluteDifferenceinanArray {
    public static int minimumAbsoluteDifference(List<Integer> arr) {
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            int temp = Math.abs(arr.get(i - 1) - arr.get(i));
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

}

class MinimumAbsoluteDifferenceinanArray_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = MinimumAbsoluteDifferenceinanArray.minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
