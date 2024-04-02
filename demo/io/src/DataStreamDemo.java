import java.io.*;

public class DataStreamDemo {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream fout = new FileOutputStream("tmp.bat");
                DataOutputStream dout = new DataOutputStream(fout);) {
            dout.writeInt(10);
            dout.writeLong(12345);
            dout.writeFloat(3.1415926f);
            dout.writeDouble(987654321.123);
            dout.writeBoolean(true);
            dout.writeChars("Goodbye! ");
        }
        try (FileInputStream fin = new FileInputStream("temp.bat");
                DataInputStream din = new DataInputStream(fin);) {
            System.out.println(din.readInt());
            System.out.println(din.readLong());
            System.out.println(din.readFloat());
            System.out.println(din.readDouble());
            System.out.println(din.readBoolean());
            char ch;
            while ((ch = din.readChar()) != '\0')
                System.out.print(ch);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file!");
        } catch (EOFException e) {
        }
    }
}
