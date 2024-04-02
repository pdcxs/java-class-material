import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileStream {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        long lines = Files.lines(path).count();
        System.out.println("There are " + lines + " lines in " + path + ".");

        List<String> upperLines = Files.lines(path)
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        for (String s : upperLines) {
            System.out.println(s);
        }
    }
}
