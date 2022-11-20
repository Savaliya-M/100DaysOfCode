import java.io.*;

public class GameofThrones {
    public static String gameOfThrones(String s) {
        int charcount[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charcount[s.charAt(i)-'a']++;
        }
        boolean oddfound = false;
        for (int i = 0; i < charcount.length; i++) {
            if(charcount[i]%2 != 0){
                if(oddfound){
                    return "NO";
                }else{
                    oddfound = true;
                }
            }
        }
        return "YES";
    }
}
class GameofThrones_Exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = GameofThrones.gameOfThrones(s);
        
        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
