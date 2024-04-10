public class Out {
    private int age;

    public class Student { // Inner class
        String name;

        public Student(String n, int a) {
            name = n;
            age = a;
        }

        public void output() {
            System.out.println("Name: " + this.name + ", Age: " + age);
        }
    }

    public void output() {
        Student stu = new Student("Eric", 24);
        stu.output();
    }

    public static void main(String[] args) {
        Out g = new Out();
        g.output();

        Out.Student stu = g.new Student("Bob", 12);
        stu.output();
    }
}
