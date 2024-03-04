import java.io.*;

public class IsFibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please input a number: ");
        int input = Integer.parseInt(br.readLine());
        int a = 0, b = 1;
        while (a < input) {
            int newA = b;
            b = a + b;
            a = newA;
        }
        if (a == input) {
            System.out.println(input + " is a Fibonacci number.");
        } else {
            System.out.println(input + " isn't a Fibonacci number.");
        }
    }
}
