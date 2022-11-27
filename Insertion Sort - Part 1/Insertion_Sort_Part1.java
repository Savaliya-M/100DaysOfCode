import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Insertion_Sort_Part1 {
    public static void insertionSort1(int n, List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            int key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
                for (int h : arr) {
                    System.out.print(h + " ");
                }
                System.out.println();
            }
            arr.set(j + 1, key);
        }
        for (int h : arr) {
            System.out.print(h + " ");
        }
        System.out.println();
    }

}

class Insertion_Sort_Part1_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Insertion_Sort_Part1.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
