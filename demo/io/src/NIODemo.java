import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class NIODemo {
    public static void main(String[] args) throws IOException {
        try (FileChannel inChannel = (FileChannel) Files.newByteChannel(Paths.get("source.txt"))) {
            long fileSize = inChannel.size();
            MappedByteBuffer mBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);
            for (int i = 0; i < fileSize; i++) {
                System.out.print(mBuf.getChar());
            }
            System.out.println();
        }
    }
}
