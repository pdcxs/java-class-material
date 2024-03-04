import java.util.Scanner;

public class SumTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input an integer: ");

        int n = sc.nextInt();
        int s = 0;
        while (n > 0) {
            s += n;
            n -= 1;
        }

        System.out.println("Sum from 1 to " + n + " is: " + s);
        sc.close();
    }
}
