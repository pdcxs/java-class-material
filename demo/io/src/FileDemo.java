import java.io.*;
import java.util.Scanner;

public class FileDemo {
    public static void main(String args[]) throws IOException {
        String name = null;
        int age = 0;
        boolean marital = false;
        File inf = new File("source.txt");
        File outf = new File("target.txt");
        if (outf.exists()) {
            System.out.println("文件已存在");
            System.exit(1);
        }
        try (Scanner in = new Scanner(inf);
                PrintWriter out = new PrintWriter(outf);) {
            while (in.hasNext()) {
                name = in.next();
                marital = in.nextBoolean();
                age = in.nextInt();
                System.out.println("姓名：" + name + " 婚否：" + marital + " 年龄：" + age);
                out.print(name);
                out.print(marital);
                out.println(age);
            }
        }
    }
}
