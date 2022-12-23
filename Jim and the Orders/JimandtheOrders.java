import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class JimandtheOrders {

    public static List<Integer> jimOrders(List<List<Integer>> orders) {
        HashMap<Integer, Integer> list = new HashMap<>();
        for (int i = 0; i < orders.size(); i++) {
            list.put(orders.get(i).get(0) + orders.get(i).get(1), i + 1);
        }
        TreeMap<Integer, Integer> sorted = new TreeMap<>(list);
        List<Integer> ss = new ArrayList<>();
        sorted.forEach(
                (key, value) -> ss.add(value));

        return ss;
    }

}

class JimandtheOrders_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> orders = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                orders.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = JimandtheOrders.jimOrders(orders);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
