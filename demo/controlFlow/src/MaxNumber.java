import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c, max, min;
        a = prompt("First Number: ", sc);
        b = prompt("Second Number: ", sc);
        c = prompt("Third Number: ", sc);
        if (a > b)
            max = a;
        else
            max = b;

        if (c > max)
            max = c;

        System.out.println("Max = " + max);

        min = a < b ? a : b;
        min = c < min ? c : min;
        System.out.println("Min = " + min);
        sc.close();
    }

    public static int prompt(String str, Scanner sc) {
        System.out.print(str);
        return sc.nextInt();
    }
}
