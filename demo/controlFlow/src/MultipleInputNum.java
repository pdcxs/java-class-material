import java.util.Scanner;

public class MultipleInputNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input several numbers.");
        System.out.println("Non digit char will stop input.");

        double sum = 0;
        while (sc.hasNextDouble()) {
            sum += sc.nextDouble();
        }

        System.out.println("The sum of inputs is: " + sum);

        sc.close();
    }
}
