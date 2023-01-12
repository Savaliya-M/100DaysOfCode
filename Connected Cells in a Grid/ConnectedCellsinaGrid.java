import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class ConnectedCellsinaGrid {

    static int helper(int i, int j, List<List<Integer>> matrix) {
        if (i < 0 || i >= matrix.size() || j < 0 || j >= matrix.get(i).size() || matrix.get(i).get(j) == 0) {
            return 0;
        }

        matrix.get(i).set(j, 0);
        int size = 1;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int m = j - 1; m <= j + 1; m++) {
                size += helper(k, m, matrix);
            }
        }
        return size;
    }

    public static int connectedCell(List<List<Integer>> matrix) {
        int max = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == 1) {
                    max = Math.max(max, helper(i, j, matrix));
                }
            }
        }
        return max;
    }

}

class ConnectedCellsinaGrid_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = ConnectedCellsinaGrid.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
