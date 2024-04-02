public class HandleException {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(String.format(
                    "arr[%d] / %d = %d",
                    i, i, arr[i] / i));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Index out of bound: " + i);
            } catch (ArithmeticException e) {
                System.err.println("Divided by zero!");
            } catch (Exception e) {
                System.err.println("Catch error! " + e.getMessage());
            } finally {
                System.out.println("i = " + i);
            }
        }
        System.out.println("Continue!");
    }
}
