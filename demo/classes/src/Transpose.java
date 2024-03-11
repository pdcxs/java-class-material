public class Transpose {
    static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}};
        printMat(mat);
        System.out.println();
        printMat(transpose(mat));
    }

    static void printMat(int[][] mat) {
        for (int[] row : mat) {
            for (int n : row) {
                System.out.print(n + "\t");
            }
            System.out.println();
        }
    }
}
