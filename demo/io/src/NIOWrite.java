import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOWrite {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("test.txt");
        Charset charset = Charset.forName("utf-8");
        String s = "我爱你中国！\nHello Java!";

        try (BufferedWriter out = Files.newBufferedWriter(path, charset)) {
            out.write(s);
        }

        try (BufferedReader in = Files.newBufferedReader(path, charset)) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
