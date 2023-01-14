import java.io.*;
import java.util.*;

public class BeautifulQuadruples {

    static long beautifulQuadruples(int a, int b, int c, int d) {
        long count = 0;

        Map<Integer, Integer> map = new HashMap();

        int[] ar = new int[4];
        ar[0] = a;
        ar[1] = b;
        ar[2] = c;
        ar[3] = d;

        Arrays.sort(ar);

        long acc = 0;
        for (int ai = 1; ai <= ar[2]; ai++) {
            for (int bi = ai; bi <= ar[3]; bi++) {
                int xor = ai ^ bi;
                map.put(xor, map.getOrDefault(xor, 0) + 1);
                acc += 1L;
            }
        }

        for (int x = 1; x <= ar[1]; x++) {
            for (int w = 1; w <= Math.min(ar[0], x); w++) {
                int xor = w ^ x;
                count += acc - map.getOrDefault(xor, 0);
            }

            int y = x;
            for (int z = x; z <= ar[3]; z++) {
                int xor = y ^ z;
                map.put(xor, map.getOrDefault(xor, 0) - 1);
                acc -= 1L;

            }

        }
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] abcd = scanner.nextLine().split(" ");

        int a = Integer.parseInt(abcd[0].trim());

        int b = Integer.parseInt(abcd[1].trim());

        int c = Integer.parseInt(abcd[2].trim());

        int d = Integer.parseInt(abcd[3].trim());

        long result = beautifulQuadruples(a, b, c, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
