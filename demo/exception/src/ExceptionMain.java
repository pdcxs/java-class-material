import java.io.*;

public class ExceptionMain {
    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("Please input a string: ");

                str = buf.readLine();

                if (str.length() > 0) {
                    break;
                } else {
                    throw new IOException();
                }
            } catch (IOException e) {
                System.out.println("Empty String!!!");
                continue;
            }
        }

        String s = str.toUpperCase();
        System.out.println(s);
        buf.close(); // May throw IOException
    }
}
