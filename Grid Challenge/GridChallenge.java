import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class GridChallenge {
    public static String strsort(String s) {
        char ch[] = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    public static String gridChallenge(List<String> grid) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            String str = strsort(grid.get(i));
            list.add(str);
        }
        int len = list.get(0).length();
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < len; j++) {
                if (list.get(i - 1).charAt(j) > list.get(i).charAt(j)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

}

class GridChallenge_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String result = GridChallenge.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
