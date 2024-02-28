/**
 * JavaDoc: Demo for showing how to use javadoc.
 * <p> Generate Doc with {@code javadoc -d doc src/*.java} </p>
 *
 * @author pdcxs
 * @version 1.0
 */
public class JavaDoc {
    /**
     * Main function of this application.
     * <p> Print some calculation results. </p>
     *
     * @param args Arguments for application.
     */
    public static void main(String[] args) {
        System.out.println(gcd(49, 91));
    }

    /**
     * Calculate Greatest Common Divider of two integers
     *
     * @param a First Integer
     * @param b Second Integer
     * @return gcd of a and b
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
