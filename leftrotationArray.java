import java.util.*;
public class leftrotationArray {
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int d = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int j = 0; j < d; j++) {
                int temp = arr[0];
                for (int i = 0; i < n-1; i++) {
                    arr[i] = arr[i+1];
                }
                arr[n-1]=temp;
            }
            for (int i : arr) {
                System.out.print(i+" ");
            }
        }
}
