public class ExtendThread {
    public static void main(String[] args) {
        NamedThread t1 = new NamedThread("Thread 1");
        NamedThread t2 = new NamedThread("Thread 2");

        t1.start();
        t2.start();
        System.out.println("Main is over!");
    }
}

class NamedThread extends Thread {
    private String name;

    NamedThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep((int) (1000 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println(name + " is running.");
        }
    }
}