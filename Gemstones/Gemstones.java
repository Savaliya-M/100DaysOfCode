package Gemstones;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Gemstones {
    public static int gemstones(List<String> arr) {
        int count[] = new int[26];
        for (int i = 0; i < arr.get(0).length(); i++) {
            count[arr.get(0).charAt(i)-'a']++;
        }
        
        for (int i = 1; i < arr.size(); i++) {
            int tempcount[] = new int[26];
            for (int j = 0; j < arr.get(i).length(); j++) {
                tempcount[arr.get(i).charAt(j)-'a']++;
            }
            
            for (int j = 0; j < 26; j++) {
                if(count[j] != 0 && tempcount[j]!=0){
                    count[j]=1;
                }else{
                    count[j]=0;
                }
            }
        }
        int NoOfGemStone = 0;
        for (int i : count) {
            if(i==1){
                NoOfGemStone++;
            }
        }
        return NoOfGemStone;
    }

}

class Gemstones_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Gemstones.gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
