import java.util.Scanner;

public class BubbleSort {

    int[] BubbleSort(int arr[], int n) {
        for (int i = 1; i <= n - 1; i++) {
            for (int j = n; j >= i + 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

    void PrintArray(int arr[]) {
        for (int i = 1; i <= arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

class BubbleSort_Exe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter how many values you want to enter : ");
        int n = sc.nextInt();
        int arr[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // System.out.print("No. " + (i) + " ");
            arr[i] = sc.nextInt();
        }

        BubbleSort DB = new BubbleSort();
        DB.PrintArray(DB.BubbleSort(arr, n));

    }
}
