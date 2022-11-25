import java.io.*;

public class BeautifulBinaryString {
    public static int beautifulBinaryString(String b) {
        int count = 0;
        char arr[] = new char[b.length()];
        arr=b.toCharArray();
        for (int i = 1; i < arr.length-1; i++) {
            if(arr[i-1]=='0' && arr[i]=='1' && arr[i+1]=='0'){
                arr[i+1]=1;
                count++;
            }
        }
        return count;
    }

}

class BeautifulBinaryString_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String b = bufferedReader.readLine();

        int result = BeautifulBinaryString.beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
