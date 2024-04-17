public class BadMoneyTaker {
    public static void main(String[] args) {
        BadCustomer c1 = new BadCustomer();
        BadCustomer c2 = new BadCustomer();

        c1.start();
        c2.start();
    }
}

class BadCustomer extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            BadBank.take(100);
        }
    }
}

class BadBank {
    private static int money = 2000;

    public static void take(int amount) {
        int temp = money;
        temp -= amount;
        try {
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
        }
        money = temp;
        System.out.println("Money = " + money);
    }
}