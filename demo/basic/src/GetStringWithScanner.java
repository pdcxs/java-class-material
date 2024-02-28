import java.util.Scanner;

/**
 * Show how to get strings with {@code Scanner}
 */
public class GetStringWithScanner {
    /**
     * Main function.
     * @param args Arguments of application.
     */
    public static void main(String[] args) {
        String s1, s2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input first argument: ");
        s1 = sc.nextLine();

        System.out.print("Please input second argument: ");
        s2 = sc.next();

        System.out.println("Your input is: " + s1 + " and " + s2);
        sc.close();
    }
}
