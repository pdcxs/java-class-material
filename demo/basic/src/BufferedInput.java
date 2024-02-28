import java.io.*;

/**
 * Get user input with {@code BufferedReader}
 */
public class BufferedInput {
    /**
     * Main function.
     * @param args Arguments of application.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please input some text: ");
        String input = br.readLine();
        System.out.println("Your input is: " + input);
    }
}
