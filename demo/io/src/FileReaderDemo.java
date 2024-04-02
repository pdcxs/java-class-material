import java.io.*;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        char[] c = new char[500];
        try (FileReader fr = new FileReader(".\\test.txt");) {
            int num = fr.read(c);
            String str = new String(c, 0, num);
            System.out.println("Read " + num + " chars, which is: ");
            System.out.println(str);
        }
    }
}
