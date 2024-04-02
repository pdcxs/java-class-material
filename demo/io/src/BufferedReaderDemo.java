import java.io.*;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        String thisLine;
        int count = 0;
        try (FileReader fr = new FileReader(".\\test.txt");
                BufferedReader bfr = new BufferedReader(fr);) {
            while ((thisLine = bfr.readLine()) != null) {
                count++;
                System.out.println(thisLine);
            }
            System.out.println("Read " + count + " lines.");
        }
    }
}
