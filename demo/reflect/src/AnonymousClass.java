public class AnonymousClass {
    public static void main(String[] args) {
        Inner i = (new Inner() {
            Inner setName(String n) {
                name = n;
                System.out.println("Name: " + name);
                return this;
            }
        }).setName("Eric");
        System.out.println(i.name);

        (new Inner() {
            void setName(String n) {
                name = n;
                System.out.println("Name: " + name);
            }
        }).setName("Tom");
    }

    static class Inner {
        String name;
    }
}