import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input a number: ");
        int n = sc.nextInt();

        System.out.println(n + "! = " + factorial(n));
        sc.close();
    }

    public static int factorial(int n) {
        if (n < 2) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
