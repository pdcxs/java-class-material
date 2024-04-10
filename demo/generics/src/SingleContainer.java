import java.util.ArrayList;
import java.util.List;

public class SingleContainer <T> {
    final T element;

    SingleContainer(T value) {
        element = value;
    }

    @Override
    public String toString() {
        return element.toString();
    }

    public T getElement() {
        return element;
    }

    public static void main(String[] args) {
        SingleContainer<Integer> c1 = new SingleContainer<Integer>(42);
        SingleContainer<String> c2 = new SingleContainer<String>("Hello");

        System.out.println(c1);
        System.out.println(c2.getElement());

        List<SingleContainer<?>> lst = new ArrayList<>();
        lst.add(new SingleContainer<Double>(12.3));
        lst.add(new SingleContainer<Double>(35.6));
        lst.add(new SingleContainer<>("Hello"));
        for (SingleContainer<?> n : lst) {
            System.out.println(n);
        }
    }
}
