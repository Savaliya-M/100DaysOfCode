import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class GridlandMetro {

    public static long gridlandMetro(int n, int m, int k, List<List<Integer>> track) {
        long total = (long) n * m;
        if (k == 0) {
            return total;
        }

        Map<Integer, List<Integer>> arr = new HashMap<>();
        for (List<Integer> list : track) {
            if (arr.containsKey(list.get(0))) {
                List<Integer> temp = list;
                if (arr.get(list.get(0)).get(0) > temp.get(0)) {
                    arr.get(list.get(0)).set(0, temp.get(0));
                }
                if (arr.get(list.get(0)).get(1) < temp.get(1)) {
                    arr.get(list.get(0)).set(1, temp.get(1));
                }
            } else {
                arr.put(list.get(0), new ArrayList());
                arr.get(list.get(0)).add(list.get(1));
                arr.get(list.get(0)).add(list.get(2));
            }
        }
        Iterator<Integer> it = arr.keySet().iterator();
        while (it.hasNext()) {
            int key = (int) it.next();
            total -= (arr.get(key).get(1) - arr.get(key).get(0)) + 1;
        }
        return total;
    }

}

class GridlandMetro_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> track = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                track.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = GridlandMetro.gridlandMetro(n, m, k, track);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
