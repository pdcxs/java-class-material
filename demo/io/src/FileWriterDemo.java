import java.io.*;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter(".\\test2.txt");
        char[] c = { 'H', 'e', 'l', 'l', 'o', '\r', '\n' };
        String str = "Welcome to Java";
        fw.write(c);
        fw.write(str);
        if (fw != null)
            fw.close();
    }
}