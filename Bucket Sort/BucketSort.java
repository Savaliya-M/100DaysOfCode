import java.util.*;

public class BucketSort {
    // initialData function is used to find maximum element from the input
    // and find how many buckets are required.
    int[] initialData(int[] iarr) {
        int m = iarr[0];
        for (int i = 1; i < iarr.length; i++) {
            if (m < iarr[i]) {
                m = iarr[i];
            }
        }
        int TotalBucket = (int) Math.sqrt(iarr.length);
        return new int[] { m, TotalBucket };
    }

    // findBucket Function is used to find currect bucket for element
    int findBucket(int i, int[] arr) {
        return (int) ((double) i / arr[0] * (arr[1] - 1));
    }

    // BucketSort is used to sort element
    void BucketSort(int[] iarr) {
        int dataarr[] = initialData(iarr);

        List[] buckets = new List[dataarr[1]];

        // here I create Array List for all buckets
        for (int i = 0; i < dataarr[1]; i++) {
            buckets[i] = new ArrayList();
        }

        // for each loop to distribute data across the buckets
        for (int i : iarr) {
            buckets[findBucket(i, dataarr)].add(i);
        }

        // for each loop for sort all the array of buckets
        for (List bucket : buckets) {

            for (int i = 1; i < bucket.size(); i++) {
                int key = (int) bucket.get(i);
                int j = i - 1;
                while (j >= 0 && (int) bucket.get(j) > key) {
                    bucket.set(j + 1, bucket.get(j));
                    j--;
                }
                bucket.set(j + 1, key);
            }
        }

        // nested for loop for merging the buckets
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (Object a : buckets[i]) {
                iarr[k++] = (int) a;
            }
        }

        for (int a : iarr) {
            System.out.print(a + " ");
        }
    }

}

class BucketSort_exe {
    public static void main(String[] args) {
        BucketSort d = new BucketSort();
        Scanner sc = new Scanner(System.in);
        System.out.print("enter how many number you want to enter : ");
        int n = sc.nextInt();
        int input[] = new int[n];
        System.out.println("Enter the values ...");
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        System.out.println("After Sorting ...");
        d.BucketSort(input);
    }
}
