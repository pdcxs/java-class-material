import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.stream.IntStream;

public class ThreadSum {
    public static void main(String[] args) {
        // int[] arr = {1, 2, 3, 4, 5};
        System.out.println(splitSum(IntStream.range(0, 101).toArray()));
    }
    static int splitSum(int[] arr) {
        int len = arr.length;
        len /= 2;
        ArraySum s1 = new ArraySum(arr, 0, len);
        ArraySum s2 = new ArraySum(arr, len, arr.length);
        FutureTask<Integer> r1 = new FutureTask<>(s1);
        FutureTask<Integer> r2 = new FutureTask<>(s2);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            return r1.get() + r2.get();
        } catch (Exception e) {}
        return -1;
    }
}

class ArraySum implements Callable<Integer> {
    int[] input;
    int start, end;

    ArraySum(int[] input, int start, int end) {
        this.input = input;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += input[i];
        }
        return sum;
    }
}