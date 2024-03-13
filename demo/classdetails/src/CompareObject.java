public class CompareObject {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("Eric Brown");

        Person p2 = new Person();
        p2.setName("Eric", "Brown");

        Person p3 = p1;

        System.out.println(p1 == p2);
        System.out.println(p1 == p3);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
    }
}
