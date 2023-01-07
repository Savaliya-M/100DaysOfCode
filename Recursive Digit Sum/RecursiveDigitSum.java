import java.io.*;

public class RecursiveDigitSum {

    public static int superDigit(String n, int k) {
        char[] dig = n.toCharArray();
        int d = helper(dig);

        if ((d * k) <= 9) {
            return d * k;
        }

        String ss = String.valueOf(d * k);
        char[] k_char = ss.toCharArray();

        return helper(k_char);
    }

    public static int helper(char[] dig) {
        if (dig.length <= 1) {
            return dig[0] - '0';
        }

        long sum = 0;
        for (char c : dig) {
            sum += c - '0';
        }
        String str = String.valueOf(sum);
        char[] sum_char = str.toCharArray();

        return helper(sum_char);
    }
}

class RecursiveDigitSum_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = RecursiveDigitSum.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
