package heapsort;

public class HeapSort {

    public static void main(String[] args) {
        int[] a = new int[] { 4, 1, 3, 7, 2, 1, 1, 9, 100 };
        HeapSort.sort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print("" + a[i] + " ");
    }

    /**
     * Sort is implemented with heap delete. In a heap we always remove the root
     * element and we replace it with the last element in the tree, we decrease
     * the size of the heap by 1 and we heapify down. If we store the root
     * element we removed in the position heapSize we end up with a sorted array
     * (asc. for max heap and desc. for min heap)
     * 
     * @param a
     */
    public static void sort(int[] a) {

        heapify(a);
        int heapSize = a.length;
        while (heapSize > 0) {
            int root = a[0];
            a[0] = a[heapSize - 1];
            a[heapSize - 1] = root;
            heapSize--;
            heapifyDown(0, a, heapSize);
        }
    }

    private static void heapifyDown(int i, int[] a, int heapSize) {
        if (isMaxHeap(i, a, heapSize))
            return;
        int biggestChildIndex = getBiggestChildIndex(i, a, heapSize);
        int tmp = a[biggestChildIndex];
        a[biggestChildIndex] = a[i];
        a[i] = tmp;
        heapifyDown(biggestChildIndex, a, heapSize);
    }

    private static int getBiggestChildIndex(int i, int[] a, int heapSize) {
        if (!hasRightChild(i, heapSize))
            return getLeftChildIndex(i);

        int rightChildIndex = getRightChildIndex(i);
        int leftChildIndex = getLeftChildIndex(i);

        return a[leftChildIndex] >= a[rightChildIndex] ? leftChildIndex : rightChildIndex;
    }

    private static boolean isMaxHeap(int index, int[] vector, int heapSize) {
        if (isLeaf(index, heapSize))
            return true;
        return vector[index] >= vector[getBiggestChildIndex(index, vector, heapSize)];
    }

    private static boolean isLeaf(int index, int size) {
        return 2 * index + 1 >= size;
    }

    private static int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private static int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private static boolean hasRightChild(int index, int size) {
        return 2 * index + 2 < size;
    }

    private static void heapify(int[] a) {
        for (int i = a.length - 1; i >= 0; i--)
            if (!isMaxHeap(i, a, a.length))
                heapifyDown(i, a, a.length);

    }
}
