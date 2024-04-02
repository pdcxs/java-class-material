import java.io.*;

public class RandomAccessDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input file path: ");
        String path = br.readLine();
        System.out.println(path);
        File file = new File(path);

        if (file.isFile() && file.canRead() && file.canWrite()) {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            while (raf.getFilePointer() < raf.length()) {
                System.out.println(raf.readLine());
            }

            if (raf != null)
                raf.close();
        } else {
            System.out.println("File cannot be accessed!");
        }
    }
}
