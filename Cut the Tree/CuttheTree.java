import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class CuttheTree {

    public static void dfs(Integer node, List<Integer> data, Map<Integer, ArrayList<Integer>> children, int[] sums,
            boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Integer curr = stack.peek();
            visited[curr - 1] = true;
            boolean done = true;
            for (Integer u : children.get(curr)) {
                if (!visited[u - 1]) {
                    stack.push(u);
                    done = false;
                    break;
                }
            }
            if (done) {
                sums[curr - 1] = data.get(curr - 1);
                for (Integer u : children.get(curr)) {
                    sums[curr - 1] += sums[u - 1];
                }
                stack.pop();
            }
        }
    }

    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        Map<Integer, ArrayList<Integer>> tree = new HashMap<>();
        for (List<Integer> edge : edges) {
            if (!tree.containsKey(edge.get(0))) {
                tree.put(edge.get(0), new ArrayList<Integer>());
            }
            if (!tree.containsKey(edge.get(1))) {
                tree.put(edge.get(1), new ArrayList<Integer>());
            }
            tree.get(edge.get(0)).add(edge.get(1));
            tree.get(edge.get(1)).add(edge.get(0));
        }

        int[] sum = new int[data.size()];
        boolean[] visited = new boolean[data.size()];

        CuttheTree.dfs(1, data, tree, sum, visited);

        int diff = Integer.MAX_VALUE;
        for (int i = 2; i <= data.size(); i++) {
            int dif = Math.abs(sum[0] - sum[i - 1] - sum[i - 1]);
            diff = Math.min(diff, dif);
        }
        return diff;
    }

}

class CuttheTree_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, n - 1).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = CuttheTree.cutTheTree(data, edges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
