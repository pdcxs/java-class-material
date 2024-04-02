import java.io.*;

public class DirectoryOperation {
    public static void main(String[] args) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader inp = new BufferedReader(isr);) {
            String sdir = ".\\bin";
            String sfile;
            File fdir1 = new File(sdir);
            if (fdir1.exists() && fdir1.isDirectory()) {
                System.out.println(sdir + " already exists.");
                for (int i = 0; i < fdir1.list().length; i++)
                    System.out.println((fdir1.list())[i]);
                File fdir2 = new File(".\\temp");
                if (!fdir2.exists()) // 判断文件是否存在
                    fdir2.mkdir();
                System.out.println();
                for (int i = 0; i < fdir1.list().length; i++)
                    System.out.println((fdir1.list())[i]);
            }
            System.out.print("File Name: ");
            sfile = inp.readLine();
            File ffile = new File(fdir1, sfile);
            if (ffile.isFile()) {
                System.out.print("File Name: " + ffile.getName());
                System.out.print(", Path: " + ffile.getPath());
                System.out.println(", Size: " + ffile.length() + "bytes.");
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
