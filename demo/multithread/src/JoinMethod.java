public class JoinMethod {
    public static void main(String[] args) {
        NamedThread t1 = new NamedThread("Thread 1");
        NamedThread t2 = new NamedThread("Thread 2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main is over!");
    }
}