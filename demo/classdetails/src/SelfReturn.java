public class SelfReturn {
    public static void main(String[] args) {
        List lst = new List(new int[]{1, 2, 3, 4});
        lst.prepend(10).prepend(20).prepend(30);
        System.out.println(lst);
    }
}
