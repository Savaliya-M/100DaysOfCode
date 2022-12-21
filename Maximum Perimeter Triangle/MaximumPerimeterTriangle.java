import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MaximumPerimeterTriangle {

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        Collections.sort(sticks);
        int i = sticks.size() - 3;
        List<Integer> result = new ArrayList<>();
        while (i >= 0) {
            if ((sticks.get(i) + sticks.get(i + 1)) > sticks.get(i + 2)) {
                break;
            } else {
                i--;
            }
        }
        if (i < 0) {
            result.add(-1);
            return result;
        } else {
            result.add(sticks.get(i));
            result.add(sticks.get(i + 1));
            result.add(sticks.get(i + 2));
            return result;
        }

    }

}

class MaximumPerimeterTriangle_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = MaximumPerimeterTriangle.maximumPerimeterTriangle(sticks);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
