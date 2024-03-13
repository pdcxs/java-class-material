public class ThreeDimSum {
    public static void main(String[] args) {
        int[][][] arr = { { { 1, 2 }, { 3, 4, 5 } }, { { 5, 6, 7, 8 }, { 7, 8, 9, 10, 11 } } };

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    sum += arr[i][j][k];
                }
            }
        }

        System.out.println("Sum is: " + sum);

        sum = 0;
        for (int[][] i : arr) {
            for (int[] j : i) {
                for (int k : j) {
                    sum += k;
                }
            }
        }
        System.out.println("Sum is: " + sum);
    }
}
