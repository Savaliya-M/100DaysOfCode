import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
 public static String[] weightedUniformStrings(String s, List<Integer> queries) {
     int a[] = new int[s.length()];
     char c = 0;
     for (int i = 0; i < s.length(); i++) {
         a[i] = s.charAt(i)-96;
         if(s.charAt(i)==c){
             a[i] = a[i]+a[i-1];
         }
         c=s.charAt(i); 
     }
     String ss[] = new String[queries.size()];
     for (int i = 0; i < queries.size(); i++) {
         ss[i]="No";
         for (int j = 0; j < a.length; j++) {
             ss[i]="Yes";
             break;
         }
     }
     return ss;
    }

}

public class WeightedUniformStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        String result = Result.weightedUniformStrings(s, queries);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
