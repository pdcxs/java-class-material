public class TopTwoMax {
    public static void main(String[] args) {
        int max, second;
        int[] a = new int[] { 8, 50, 20, 7, 81, 55, 76, 93 };
        max = a[0] > a[1] ? a[0] : a[1];
        second = a[0] > a[1] ? a[1] : a[0];
        
        for (int i = 2; i < a.length; i++) {
            if (a[i] > max) {
                second = max;
                max = a[i];
            } else if (a[i] > second) {
                second = a[i];
            }
        }

        System.out.println("Top two numbers are: " + max + " and " + second + ".");
    }
}
