import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.stream.Collectors;

public class ClosestNumbers {

    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE, diff = 0;

        for (int i = 1; i < arr.size(); i++) {
            diff = arr.get(i) - arr.get(i - 1);
            min = Math.min(min, diff);

            if (!map.containsKey(diff))
                map.put(diff, new ArrayList<>());
            map.get(diff).add(arr.get(i - 1));
            map.get(diff).add(arr.get(i));
        }
        return map.get(min);
    }

}

class ClosestNumbers_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = ClosestNumbers.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
