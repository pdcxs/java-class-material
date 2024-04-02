public class IndexException {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        for (int i = 0; i < arr.length + 1; i++) {
            System.out.println(arr[i]);
        }
    }
}
