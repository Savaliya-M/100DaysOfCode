import java.util.*;

public class LuckBalance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int maxLuck = 0;
        ArrayList<Integer> importantContests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int luck = sc.nextInt();
            int important = sc.nextInt();

            if (important != 1) {
                maxLuck += luck;
            } else
                importantContests.add(luck);
        }

        Collections.sort(importantContests, Collections.reverseOrder());

        for (int i = 0; i < importantContests.size(); i++) {
            if (i < k)
                maxLuck += importantContests.get(i);
            else
                maxLuck -= importantContests.get(i);
        }
        System.out.println(maxLuck);
    }
}