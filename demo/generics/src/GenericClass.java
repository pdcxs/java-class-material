public class GenericClass <T> {
    T value;
    GenericClass(T value) {
        this.value = value;
    }

    <U> void printClass(U arg) {
        System.out.println("Type of arg: " + arg.getClass());
        System.out.println("Type of value: " + value.getClass());
    }

    public static void main(String[] args) {
        GenericClass<String> g = new GenericClass<String>("Hello");
        g.printClass(42);
    }
}
