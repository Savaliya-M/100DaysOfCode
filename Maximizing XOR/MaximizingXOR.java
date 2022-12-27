import java.io.*;

public class MaximizingXOR {
    public static int maximizingXor(int l, int r) {
        int ans = 0;
        for (int i = l; i < r; i++) {
            for (int j = l; j < r; j++) {
                ans = Math.max(ans, i ^ j);
            }
        }
        return ans;
    }
}

class MaximizingXOR_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        int result = MaximizingXOR.maximizingXor(l, r);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
