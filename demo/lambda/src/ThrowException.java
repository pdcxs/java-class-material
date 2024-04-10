public class ThrowException {
    public static void main(String[] args) throws MyException {
        ExceptionFunc f = n -> {
            if (n == 0) throw new MyException("Zero!");
            return 1.0 / n;
        };
        System.out.println(f.apply(10));
        System.out.println(f.apply(0));
    }
}

class MyException extends Exception {
    MyException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

interface ExceptionFunc {
    double apply(int n) throws MyException;
}