import java.io.*;
import java.util.*;

class find {
    public static int alternate(String s) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length();i++){
            set.add(s.charAt(i));
        }
        ArrayList<Character> list = new ArrayList<>(set);
        int max = 0;
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size(); j++) {
                char c1 = list.get(i);
                char c2 = list.get(j);
                int result = logic(c1,c2,s);
                if(max < result){
                    max = result;
                }
            }
        }
        return max;
    }
    
    static int logic(char c1,char c2, String s){
        int count = 0;
        char lchar = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c==c1 || c==c2){
                if(c==lchar){
                    return 0;
                }
                lchar = c;
                count++;
            }
        }
        return count;
    }
}

public class TwoCharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = find.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
