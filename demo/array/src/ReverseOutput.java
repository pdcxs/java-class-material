public class ReverseOutput {
    public static void main(String[] args) {
        int[] a = new int[5];

        // Initialize
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        // Reverse output
        for(int i = a.length - 1; i >= 0; i--) {
            System.out.println(String.format("a[%d] = %d", i, a[i]));
        }
        System.out.println("The length of array is: " + a.length);
    }
}
