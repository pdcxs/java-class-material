import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuickSort extends RecursiveAction {
    private static final long serialVersionUID = 1L;
    private final int[] array;
    private final int start;
    private final int end;

    public QuickSort(int[] array) {
        this(array, 0, array.length);
    }

    public QuickSort(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition();
        invokeAll(new QuickSort(array, start, pivotIndex),
                new QuickSort(array, pivotIndex + 1, end));
    }

    private int partition() {
        int pivot = array[start];
        int i = start + 1;
        int j = end - 1;

        while (true) {
            while (i <= j && array[i] <= pivot) {
                i++;
            }
            while (i <= j && array[j] >= pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(i, j);
        }
        swap(start, j);
        return j;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int[] arr = { 5, 4, 3, 2, 1 };
        pool.invoke(new QuickSort(arr));
        for (int i : arr) {
            System.out.print(i + " ");
        }
        pool.close();
    }
}