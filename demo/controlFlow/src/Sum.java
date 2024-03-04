public class Sum {
    public static void main(String[] args) {
        int i, n = 100, s = 0;
        for (int j = 1; j <= n; j++)
            s = s + j;
        System.out.println("1 + 2 + ... + " + n + " = " + s);
        s = 0;

        System.out.print("Sum = ");
        for (i = n; i > 1; i--) {
            s += i;
            System.out.print(i + " + ");
        }
        System.out.println(i + " = " + (s + i));
    }
}
