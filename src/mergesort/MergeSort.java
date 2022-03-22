package mergesort;

import java.util.Arrays;

/**
 * Merge sort has O(n) space complexity
 * 
 * @author david
 *
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[] { 4, 1, 3, 7, 2, 1, 1, 9, 100 };
        MergeSort.sort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print("" + a[i] + " ");
    }

    private static void sort(int[] array) {
        if (array.length <= 1)
            return;
        int[] a = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] b = Arrays.copyOfRange(array, array.length / 2, array.length);

        sort(a);
        sort(b);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < array.length) {
            while (j < a.length && k < b.length) {
                if (a[j] < b[k])
                    array[i++] = a[j++];
                else
                    array[i++] = b[k++];
            }
            while (j < a.length)
                array[i++] = a[j++];

            while (k < b.length)
                array[i++] = b[k++];
        }
    }

}
