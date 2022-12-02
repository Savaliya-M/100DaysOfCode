import java.util.*;

public class MergeSort {
    void merge(int arr[], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int Left[] = new int[n1];
        int Right[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            Left[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            Right[j] = arr[q + 1 + j];
        }
        int i = 0, j = 0, k = p;

        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                arr[k] = Left[i];
                i++;
            } else {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = Left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }

    void mergeSort(int arr[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }
}

class MergeSort_exe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeSort m1 = new MergeSort();
        System.out.print("enter how many number you want to enter : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m1.mergeSort(arr, 0, n - 1);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}