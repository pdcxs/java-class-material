public class StaticGenerics {
    static <T> SingleContainer<T> create(T value) {
        return new SingleContainer<T>(value);
    }

    public static void main(String[] args) {
        var c1 = create(12);
        var c2 = create("Hello");

        System.out.println(c1);
        System.out.println(c2.getElement());
    }
}
