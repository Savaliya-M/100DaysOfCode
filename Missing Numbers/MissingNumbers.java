import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MissingNumbers {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < brr.size(); i++) {
            int key = brr.get(i);
            Integer count = map.getOrDefault(key, 0);
            count++;
            map.put(key, count);
        }
        for (int i = 0; i < arr.size(); i++) {
            int frequency = map.get(arr.get(i));
            frequency--;
            if (frequency == 0) {
                map.remove(arr.get(i));
            } else {
                map.put(arr.get(i), frequency);
            }
        }
        Iterator itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry me = (Map.Entry) itr.next();
            int key = (Integer) me.getKey();
            output.add(key);
        }

        Collections.sort(output);
        return output;
    }

}

class MissingNumbers_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = MissingNumbers.missingNumbers(arr, brr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
