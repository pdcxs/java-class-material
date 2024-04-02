public class GetClass {
    public static void main(String[] args) {
        Person p = new Student("Bob", 21, "CS");
        System.out.println(p.getClass());
    }
}
