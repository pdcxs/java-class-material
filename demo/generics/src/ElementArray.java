public class ElementArray <T> {
    T[] arr;

    public static void main(String[] args) {
        ElementArray<Integer> ints = new ElementArray<>();
        ints.arr = new Integer[]{1, 2, 3, 4};
        for (int i : ints.arr) {
            System.out.println(i);
        }
    }
}
