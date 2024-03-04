public class Fibonacci {
    public static void main(String[] args) {
        int n = 16;
        int a = 0, b = 1;
        for (int i = 0; i < n - 1; i++) {
            System.out.print(a + ", ");
            int newA = b;
            b = a + b;
            a = newA;
        }
        System.out.println(b);
    }
}
