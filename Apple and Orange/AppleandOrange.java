import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class AppleandOrange {

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        for (int i = 0; i < apples.size(); i++) {
            apples.set(i, apples.get(i) + a);
        }
        for (int i = 0; i < oranges.size(); i++) {
            oranges.set(i, oranges.get(i) + b);
        }
        int ac = 0, oc = 0;
        for (Integer f : apples) {
            if (f >= s && f <= t) {
                ac++;
            }
        }
        for (Integer o : oranges) {
            if (o >= s && o <= t) {
                oc++;
            }
        }
        System.out.println(ac);
        System.out.println(oc);
    }

}

class AppleandOrange_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int s = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(secondMultipleInput[0]);

        int b = Integer.parseInt(secondMultipleInput[1]);

        String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(thirdMultipleInput[0]);

        int n = Integer.parseInt(thirdMultipleInput[1]);

        List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        AppleandOrange.countApplesAndOranges(s, t, a, b, apples, oranges);

        bufferedReader.close();
    }
}
