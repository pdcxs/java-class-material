public class SyncronizedDemo {
    public static void main(String[] args) {
        AddBracket caller = new AddBracket();

        Caller c1 = new Caller("Hello", caller);
        Caller c2 = new Caller("World", caller);
        Caller c3 = new Caller("Java", caller);

        c1.t.start();
        c2.t.start();
        c3.t.start();
    }
}

class AddBracket {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep((int)(Math.random() * 1000));
        } catch (InterruptedException e) {}
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    AddBracket caller;
    Thread t;
    public Caller(String msg, AddBracket caller) {
        this.msg = msg;
        this.caller = caller;
        t = new Thread(this);
    }

    @Override
    public void run() {
        synchronized(caller) {
            caller.call(msg);
        }
    }
}