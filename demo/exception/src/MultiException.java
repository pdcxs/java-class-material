public class MultiException {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int[] arr = {1, 2, 3, 4, 5};
        try {
            int result = a / b;
            System.out.println(result);
            arr[10] = 100;
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Catch: " + e);
        }
        System.out.println("Finished");
    }
}
