import java.util.Scanner;

public class SumOfFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input a number: ");

        int n = sc.nextInt();

        System.out.println("Result is: " + sumFactorial(n));

        sc.close();
    }

    public static int sumFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return Factorial.factorial(n) + sumFactorial(n - 1);
    }
}
