import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fi = new FileInputStream(args[0]);
                FileOutputStream fo = new FileOutputStream(args[1]);) {
            System.out.println("File Size: " + fi.available());
            byte[] b = new byte[fi.available()];
            fi.read(b);
            fo.write(b);
            System.out.println("File is copied!");
        }
    }
}
