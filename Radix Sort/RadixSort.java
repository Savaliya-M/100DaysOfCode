import java.util.*;

public class RadixSort {
    int getMax(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            return max;
        }
        return max;
    }

    void countingSort(int arr[], int n, int place) {
        int output[] = new int[n + 1];
        int max = (arr[0] / place) % 10;

        for (int i = 1; i < n; i++) {
            if (((arr[i] / place) % 10) > max) {
                max = (arr[i] / place) % 10;
            }
        }
        int count[] = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            count[(arr[i] / place) % 10]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / place) % 10] - 1] = arr[i];
            count[(arr[i] / place) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    void radixsort(int arr[], int n) {
        int max = getMax(arr, n);

        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(arr, n, place);
        }
    }
}

class RadixSort_exe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RadixSort r1 = new RadixSort();
        System.out.print("enter how many number you want to enter : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        r1.radixsort(arr, n);

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
