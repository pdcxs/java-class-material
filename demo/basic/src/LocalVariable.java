/**
 * Type inference for local variables
 */
public class LocalVariable {
    /**
     * Main function.
     * @param args Arguments for application.
     */
    public static void main(String[] args) {
        var a = 10.0;
        System.out.println("a = " + a);
        int var = 1;
        System.out.println("Value of var: " + var);
        var b = -var;
        System.out.println("Value of b: " + b);
    }
}
