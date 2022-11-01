package quicksort;

public class QuickSort {
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void sort(int[] array, int start, int end) {
        System.out.println(end - start);
        if (end - start <= 0)
            return;
        int p = partition(array, start, end);
        // now pivot is in its place, so we sort left and right
        sort(array, start, p - 1);
        sort(array, p + 1, end);
    }
    private static int partition(int[] array, int start, int end) {
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
        if (array[high] <= array[p]){ // pivot should end up in its place, that's why lower or EQUAL is important
            swap(array, high, p);
            p = high;
        }
        return p;
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,3,2,4,3,2,5,8,7,9};
        QuickSort.sort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print("" + a[i] + " ");
    }
}
