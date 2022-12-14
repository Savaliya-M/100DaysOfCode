import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class HackerlandRadioTransmitters {

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        Collections.sort(x);
        int counter = 0;
        int i = 0;
        while (i < x.size()) {
            counter++;
            int leftStartingPoint = i;
            while ((i + 1 < x.size()) && (x.get(i + 1) - x.get(leftStartingPoint) <= k)) {
                i++;
            }
            int middlePoint = i;
            while ((i + 1 < x.size()) && (x.get(i + 1) - x.get(middlePoint) <= k)) {
                i++;
            }
            i++;
        }
        return counter;
    }

}

class HackerlandRadioTransmitters_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> x = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = HackerlandRadioTransmitters.hackerlandRadioTransmitters(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
