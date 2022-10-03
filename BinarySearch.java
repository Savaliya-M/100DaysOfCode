import java.util.Scanner;

public class BinarySearch {
    void LinearSearch(int n, int arr[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number that you want to search : ");
        int key = sc.nextInt();
        int lo = 0;
        int hi = n;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == key) {
                System.out.println("your number " + key + " is found at " + mid + " position.");
                return;
            } else if (arr[mid] < key) {
                lo = mid + 1;
            } else if (arr[mid] > key) {
                hi = mid - 1;
            }
        }
    }
}

class DSA_BinarySearch_Exe {
    public static void main(String[] args) {
        BinarySearch DB = new BinarySearch();
        Scanner sc = new Scanner(System.in);
        System.out.print("enter how many values you want to enter : ");
        int n = sc.nextInt();
        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.print("No. " + i + " ");
            arr[i] = sc.nextInt();
        }
        DB.LinearSearch(n, arr);
    }
}
