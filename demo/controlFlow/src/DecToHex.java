import java.util.Scanner;

public class DecToHex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please input a number: ");
        int n = sc.nextInt();

        System.out.println("Hex of " + n + " is 0x" + hex(n));

        sc.close();
    }

    public static String hex(int n) {
        if (n == 0) {
            return "";
        }
        int num = n % 16;
        char digit;
        if (num < 10) {
            digit = (char)(num + '0');
        } else {
            digit = (char)(num - 10 + 'A');
        }

        return hex(n / 16) + digit;
    }
}
