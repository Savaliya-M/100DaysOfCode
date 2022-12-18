import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class MarcsCakewalk {
    public static long marcsCakewalk(List<Integer> calorie) {
        Collections.sort(calorie, Collections.reverseOrder());
        long mile = 0;
        for (int i = 0; i < calorie.size(); i++) {
            mile += (calorie.get(i) * (Math.pow(2, i)));
        }
        return mile;
    }
}

class MarcsCakewalk_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> calorie = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = MarcsCakewalk.marcsCakewalk(calorie);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
