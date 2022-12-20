import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class BeautifulPairs {

    public static int beautifulPairs(List<Integer> A, List<Integer> B) {
        int count[] = new int[1005];
        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            count[A.get(i)]++;
        }
        for (int i = 0; i < B.size(); i++) {
            if (count[B.get(i)] > 0) {
                result++;
                count[B.get(i)]--;
            }
        }
        if (result == A.size()) {
            return --result;
        } else {
            return ++result;
        }
    }

}

class BeautifulPairs_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = BeautifulPairs.beautifulPairs(A, B);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
