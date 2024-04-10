import java.util.*;
import java.util.stream.*;

public class StaticMap {
    public static void main(String[] args) {
        List<Double> lst = Arrays.asList(1, 2, 3, 4)
                .stream()
                .map(Math::sqrt)
                .collect(Collectors.toList());
        lst.forEach(System.out::println);
        System.out.println(
            Stream.iterate(1.0, i -> i + 1)
                .limit(101)
                .map(Math::sqrt)
                .reduce(0.0, (i, s) -> i + s)
        );
    }
}
