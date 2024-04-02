public class ThrowException {
    public static void main(String[] args) {
        try {
            System.out.println("Here");
            throw new ArithmeticException();
            // System.out.println("And there.");
        } catch (ArithmeticException e) {
            System.out.println("Catch " + e);
            e.printStackTrace();
        }
    }
}
