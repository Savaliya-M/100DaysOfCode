import java.io.*;
import java.util.*;

public class MandragoraForest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            
            long totalH = 0L;
            List<Long> nums = new ArrayList<Long>();
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            for (String s : tokens) {
                long nj = Long.parseLong(s);
                nums.add(nj);
                totalH += nj;
            }
            Collections.sort(nums);
            long bestScore = 0;
            int eaten = 0;
            long s = totalH;
            
            while (s > bestScore) {
                bestScore = s;
                totalH -= nums.get(eaten);
                eaten += 1;
                s = (1L + eaten) * totalH;
            }
            System.out.println(bestScore);
        }
    }
}