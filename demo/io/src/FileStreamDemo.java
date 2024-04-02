import java.io.*;

public class FileStreamDemo {
    public static void main(String[] args) {
        char ch;
        int data;
        try (FileInputStream fin = new FileInputStream(FileDescriptor.in);
                FileOutputStream fout = new FileOutputStream("./myfile.txt");) {
            System.out.print("Input a string ended with #: ");
            while ((ch = (char) fin.read()) != '#')
                fout.write(ch);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file.");
        } catch (IOException e) {
        }
        try (FileInputStream fin = new FileInputStream(".\\source.txt ");
                FileOutputStream fout = new FileOutputStream(FileDescriptor.out);) {
            while (fin.available() > 0) {
                data = fin.read();
                fout.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
