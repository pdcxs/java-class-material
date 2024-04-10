import java.io.File;
import java.io.IOException;

public class ListDir {
    public static void main(String[] args) throws IOException {
        String path = args.length == 0 ? "." : args[0];
        listDir(new File(path));
    }

    static void listDir(File dir) {
        if (dir.isFile()) {
            System.out.println(dir.getAbsolutePath());
            return;
        }
        if (dir.isDirectory()) {
            File[] contents = dir.listFiles();
            for (File c : contents) {
                listDir(c);
            }
        }
    }
}
