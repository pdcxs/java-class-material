import java.util.concurrent.locks.ReentrantLock;

public class LockedBankDemo {
    public static void main(String[] args) {
        LockedBank bank = new LockedBank(2000);
        LockCustomer c1 = new LockCustomer(bank);
        LockCustomer c2 = new LockCustomer(bank);

        c1.start();
        c2.start();
    }
}

class LockedBank {
    private int money;
    private ReentrantLock lock = new ReentrantLock();

    LockedBank(int money) {
        this.money = money;
    }

    void take(int amount) {
        lock.lock();

        try {
            int temp = money;
            temp -= amount;
            try {
                Thread.sleep((int)(1000 * Math.random()));
            } catch (InterruptedException e) {
            }
            money = temp;
            System.out.println("Money = " + money);
        } finally {
            lock.unlock();
        }
    }
}

class LockCustomer extends Thread {
    private LockedBank bank;
    LockCustomer(LockedBank bank) {
        this.bank = bank;
    }
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            bank.take(100);
        }
    }
}