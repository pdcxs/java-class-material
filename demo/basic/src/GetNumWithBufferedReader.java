import java.io.*;

/**
 * Read an number from user with {@code BufferedReader}.
 */
public class GetNumWithBufferedReader {
    /**
     * Main function.
     *
     * @param args Arguments of application.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please input a number: ");
        String input = br.readLine();

        float num = Float.parseFloat(input);
        System.out.println("Square of " + num + " is " + num * num + ".");
    }
}
