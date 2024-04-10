import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEach {
    public static void main(String[] args) {
        List<String> lst = Arrays.asList("Eric", "Tom", "Alice", "Amy");

        lst.forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println(t);
            }
        });

        System.out.println();
        lst.forEach(s -> System.out.println(s));
        System.out.println();
        lst.forEach(System.out::println);
    }
}
