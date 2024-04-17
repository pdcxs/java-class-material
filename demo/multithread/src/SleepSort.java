import java.util.*;

public class SleepSort {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 0, 4, 2 };

        Arrays.stream(arr).forEach(i -> (new SortThread(i)).start());
    }
}

class SortThread extends Thread {
    int time;

    SortThread(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        try {
            sleep(time * 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(time);
    }
}