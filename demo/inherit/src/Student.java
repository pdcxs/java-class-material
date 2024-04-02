public class Student extends Person {
    private String department;

    public Student() {
        System.out.println("Called constructor of Student.");
    }

    public Student(String name, int age, String department) {
        super(name, age);
        System.out.println("Called Constructor with parameters of Student.");
        this.department = department;
    }

    public void setDepartment(String dprtmnt) {
        department = dprtmnt;
        System.out.println("I'm in " + department + ".");
    }

    public static void main(String[] args) {
        Student stu = new Student();
        stu.setNameAge("Bob", 21);
        stu.show();
        stu.setDepartment("Computer Science");
    }
}
