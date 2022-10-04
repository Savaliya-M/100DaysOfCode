import java.util.Scanner;

public class insertionSort {
    int[] InsertionSort(int arr[], int n) {
        for (int j = 2; j <= n; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i > 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
        return arr;
    }

    void PrintArray(int arr[]) {
        for (int i = 1; i <= arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}

class insertionSort_Exe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter how many values you want to enter : ");
        int n = sc.nextInt();
        int arr[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            System.out.print("No. " + (i) + " ");
            arr[i] = sc.nextInt();
        }
        insertionSort Is = new insertionSort();
        Is.PrintArray(Is.InsertionSort(arr, n));

    }
}
