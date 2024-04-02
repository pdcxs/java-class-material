import java.io.*;

public class StandardIO {
    public static void main(String[] args) throws IOException {
        byte[] b = new byte[128];
        System.out.print("Input a string: ");
        int count = System.in.read(b);
        for (int i = 0; i < count; i++)
            System.out.print(b[i] + " ");
        System.out.println();
        for (int i = 0; i < count - 2; i++)
            System.out.print((char) b[i] + " ");
        System.out.println();
        System.out.println("Character count: " + count);
        Class<?>[] types = new Class[2];
        types[0] = System.in.getClass();
        types[1] = System.out.getClass();
        System.out.println("Class of in: " + types[0].toString());
        System.out.println("Class of out: " + types[1].toString());

        System.setOut(new PrintStream("hello.txt"));
        System.out.println(123);
    }
}
