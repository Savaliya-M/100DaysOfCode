import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SummingPieces {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long sum = 0;
        long[] powers2 = new long[n + 1];
        powers2[0] = 1;
        for (int i = 1; i <= n; i++)
            powers2[i] = (powers2[i - 1] << 1) % 1000000007;

        for (int i = 1; i <= n; i++) {
            long left = ((powers2[i] - 1) * powers2[n - i]) % 1000000007;
            long right = ((powers2[1 + n - i] - 1) * powers2[i - 1]) % 1000000007;
            long v = left + right - powers2[n - 1];
            sum = (sum + (v * in.nextLong())) % 1000000007;
        }
        System.out.println(sum);

    }
}