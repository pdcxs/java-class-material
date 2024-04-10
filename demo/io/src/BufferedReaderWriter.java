import java.io.*;

public class BufferedReaderWriter {
    public static void main(String[] args) throws IOException {
        String str;
        try (BufferedReader in = new BufferedReader(new FileReader(".\\test.txt"));
                BufferedWriter out = new BufferedWriter(new FileWriter(".\\test1.txt"));) {
            while ((str = in.readLine()) != null) {
                System.out.println(str);
                out.write(str);
                out.newLine();
            }
            out.flush();
        } catch (IOException ioe) {
            System.out.println("Exception: " + ioe);
        }
    }
}
