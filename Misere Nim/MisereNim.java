import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class MisereNim {

    public static String misereNim(List<Integer> s) {
        int count = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == 1) {
                count++;
            }
        }
        if (count == s.size()) {
            if (count % 2 == 0) {
                return "First";
            } else {
                return "Second";
            }
        }
        int x = 0;
        for (int stones : s) {
            x ^= stones;
        }
        if (x == 0) {
            return "Second";
        }
        return "First";
    }

}

class MisereNim_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = MisereNim.misereNim(s);

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
