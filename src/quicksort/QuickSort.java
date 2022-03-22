package quicksort;

public class QuickSort {
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(int[] array, int start, int end) {
        if (end - start <= 0)
            return;
        int p = start;
        int low = start;
        int high = end;
        while (low < high) {
            while (array[low] <= array[p] && low < end)
                low++;
            while (array[high] > array[p] && high > start)
                high--;
            if (low < high) // check that low and high didn't cross yet
                swap(array, low, high);
        }
        if (array[high] < array[p])
            swap(array, high, p);
        // now pivot is in its place, so we sort left and right
        sort(array, start, p - 1);
        sort(array, p + 1, end);
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[] { 4, 1, 3, 7, 2, 1, 1, 9, 100 };
        QuickSort.sort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print("" + a[i] + " ");
    }
}
