import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BreakingtheRecords {
    public static List<Integer> breakingRecords(List<Integer> scores) {
        int max = scores.get(0), min = scores.get(0), mc = 0, wc = 0;
        for (Integer b : scores) {
            if (b > max) {
                mc++;
                max = b;
            }
            if (b < min) {
                wc++;
                min = b;
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(mc);
        arr.add(wc);
        return arr;
    }

}

class BreakingtheRecords_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = BreakingtheRecords.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
