public class InterfaceThread {
    public static void main(String[] args) {
        IThread t1 = new IThread("Thread 1");
        IThread t2 = new IThread("Thread 2");

        new Thread(t1).start();
        new Thread(t2).start();
    }
}

class IThread implements Runnable {
    String name;

    IThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep((int)(1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " is running.");
        }
    }
}