import java.io.*;

public class CaesarCipher {
    public static String caesarCipher(String s, int k) {
        String res = "";
        k = k%26;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                char newch = (char) (ch+k);
                if(newch>90){
                    newch = (char)(newch%90+64); 
                }
                res += newch;
            }else if(Character.isLowerCase(ch)){
                char newch = (char)(ch+k);
                if(newch>122){
                    newch = (char) (newch%122+96);
                }
                res+=newch;
            }else{
                res+=ch;
            }
        }
        return res;
    }

}

class CaesarCipher_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = CaesarCipher.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
