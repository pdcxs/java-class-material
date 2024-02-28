/**
 * Show type auto convertion between int and float.
 */
public class IntAndFloat {
    /**
     * Main function.
     *
     * @param args Arguments of application.
     */
    public static void main(String[] args) {
        int a = 155;
        int b = 9;
        float g, h;
        System.out.println("a = " + a + ", b = " + b);
        g = a / b;
        System.out.println("a / b = " + g);
        System.out.println("a = " + a + ", b = " + b);
        h = (float) a / b;
        System.out.println("a / b = " + h);
        System.out.println("(int) h = " + (float) ((int) h));
    }
}
