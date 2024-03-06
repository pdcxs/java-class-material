public class PascalTriangle {
    public static void main(String[] args) {
        int level = 7;
        int[][] triangle = new int[level][];
        
        triangle[0] = new int[]{1};

        for (int i = 1; i < level; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        for (int i = 0; i < level; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(triangle[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
