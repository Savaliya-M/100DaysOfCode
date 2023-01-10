import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class MinimumLoss {

    public static int minimumLoss(List<Long> price) {
        int loss = Integer.MAX_VALUE;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < price.size(); i++) {
            map.put(price.get(i), i);
        }
        Collections.sort(price);
        for (int i = price.size() - 1; i > 0; i--) {
            if (price.get(i) - price.get(i - 1) < loss) {
                if (map.get(price.get(i)) < map.get(price.get(i - 1))) {
                    loss = (int) (price.get(i) - price.get(i - 1));
                }
            }
        }

        return loss;
    }

}

class MinimumLoss_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> price = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        int result = MinimumLoss.minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
