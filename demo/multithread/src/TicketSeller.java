public class TicketSeller {
    public static void main(String[] args) {
        Seller seller1 = new Seller();
        Seller seller2 = new Seller();
        Seller seller3 = new Seller();

        seller1.start();
        seller2.start();
        seller3.start();
    }
}

class Seller extends Thread {
    int ticket = 10;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                try {
                    sleep((int) (Math.random() * 10));
                } catch (InterruptedException e) {
                }
                System.out.println(getName() + " Seller sells No. " + ticket + " ticket.");
                ticket--;
            } else {
                // System.exit(0);
                break;
            }
        }
    }
}