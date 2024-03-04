import java.io.*;

public class GreatestFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Input a number greater than 1: ");
        int m = Integer.parseInt(br.readLine());

        int s = 1;
        int n = 1;

        while (s * (n + 1) < m) {
            n += 1;
            s = s * n;
        }

        System.out.println("S = " + s + ", N = " + n);
    }
}
