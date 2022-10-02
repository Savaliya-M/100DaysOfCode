import java.util.*;

public class linearSearch {
    void LinearSearch(int n, int arr[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter the number that you want to search : ");
        int key = sc.nextInt();
        int i = 1;
        while (i <= n && arr[i] != key) {
            i++;
        }
        if (i <= n) {
            System.out.println("your number " + key + " is found at " + i + " position.");
        } else {
            System.out.println("your number is not in the list.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter how many values you want to enter : ");
        int n = sc.nextInt();
        int arr[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            System.out.print("No. " + i + " ");
            arr[i] = sc.nextInt();
        }
        linearSearch DL = new linearSearch();
        DL.LinearSearch(n, arr);
    }

}
