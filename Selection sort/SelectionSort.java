import java.util.Scanner;

class SelectionSort {

    int[] selectionsort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            // swap
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        SelectionSort ss = new SelectionSort();
        System.out.println("How many element you want to enter: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Entetr the " + n + " elements.");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Sorted Array Element");
        ss.printArray(ss.selectionsort(arr));
    }
}