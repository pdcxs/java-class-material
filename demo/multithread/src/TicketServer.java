public class TicketServer {
    public static void main(String[] args) {
        Server server = new Server();
        // Bad Idea
        Thread window1 = new Thread(server, "Window 1");
        Thread window2 = new Thread(server, "Window 2");
        Thread window3 = new Thread(server, "Window 3");

        window1.start();
        window2.start();
        window3.start();
    }
}

class Server implements Runnable {
    private int tickets = 10;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + " sells No. " + tickets-- + " ticket.");
                // this may cause fault!
                // try {
                //     Thread.sleep(1000);
                // } catch (Exception e) {}
            } else {
                // System.exit(0);
                break;
            }
        }
    }
}