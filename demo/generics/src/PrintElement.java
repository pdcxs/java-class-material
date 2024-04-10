public class PrintElement {
    static void print(SingleContainer<? extends String> str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        print(new SingleContainer<String>("Hello"));
        // print(new SingleContainer<Integer>(12));
    }
}
