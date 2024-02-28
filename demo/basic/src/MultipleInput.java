import java.io.*;

/**
 * Show how to get multiple inputs.
 */
public class MultipleInput {
    /**
     * Main function.
     * @param args Arguments of application.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please input first number: ");
        float num1 = Float.parseFloat(br.readLine());

        System.out.print("Please input second number: ");
        float num2 = Float.parseFloat(br.readLine());

        System.out.println("The product of the two numbers is " + num1 * num2);
    }

}
