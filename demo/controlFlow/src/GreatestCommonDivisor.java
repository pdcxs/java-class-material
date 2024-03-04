import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("First integer: ");
        int a = sc.nextInt();

        System.out.print("Second integer: ");
        int b = sc.nextInt();

        do {
            int nextB = a % b;
            a = b;
            b = nextB;
        } while (b != 0);

        System.out.println("GCD is " + a);

        sc.close();
    }
}
