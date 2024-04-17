public class TicketSaverAndSeller {
    public static void main(String[] args) {
        TicketContainer t = new TicketContainer(10);
        new Producer(t).start();
        new Consumer(t).start();
    }
}

class TicketContainer {
    int capacity;
    int ticketId = 0;
    boolean ticketAvailable = false;

    TicketContainer(int capacity) {
        this.capacity = capacity;
    }

    synchronized void put() {
        if (ticketAvailable) {
            try {
                wait();
            } catch (Exception e) {}
        }
        System.out.println("Saved No. " + (++ticketId) + " Ticket.");
        ticketAvailable = true;
        notify();
    }

    synchronized void sell() {
        if (!ticketAvailable) {
            try {
                wait();
            } catch (Exception e) {}
        }
        System.out.println("Sells No. " + ticketId + " Ticket.");
        ticketAvailable = false;
        notify();
        if (ticketId == capacity)
            ticketId = capacity + 1;
        // selling is over when ticketId > capacity
    }
}

class Producer extends Thread {
    TicketContainer t;

    Producer(TicketContainer t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (t.ticketId < t.capacity) {
            t.put();
        }
    }
}

class Consumer extends Thread {
    TicketContainer t;
    Consumer(TicketContainer t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (t.ticketId <= t.capacity) {
            t.sell();
        }
    }
}