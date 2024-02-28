import java.util.Scanner;

/**
 * Show how to get multiple inputs with {@code Scanner}
 */
public class MultipleInputScanner {
    /**
     * Main function.
     * @param args Arguments of the applications.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input a number: ");
        float num1 = sc.nextFloat();

        System.out.print("Please input another number: ");
        float num2 = sc.nextFloat();

        System.out.println(num1 + " * " + num2 + " = " + num1 * num2);

        sc.close();
    }
}
