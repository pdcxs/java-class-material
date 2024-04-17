public class MoneyTaker {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        c1.start();
        c2.start();
    }
}

class Customer extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 4; i++) {
            Bank.take(100);
        }
    }
}

class Bank {
    private static int money = 2000;

    static public synchronized void take(int amount) {
        int temp = money;
        temp -= amount;
        try {
            Thread.sleep((int) (1000 * Math.random()));
        } catch (Exception e) {
        }
        money = temp;
        System.out.println("Money = " + money);
    }
}