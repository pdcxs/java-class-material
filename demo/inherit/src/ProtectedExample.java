public class ProtectedExample {
    public static void main(String[] args) {
        ProtectedStudent stu = new ProtectedStudent("Bob", 21, "Computer Science");
        System.out.println(stu);
    }
}

class ProtectedPerson {
    protected String name;
    protected int age;

    ProtectedPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " is " + this.age + " years old.";
    }
}

class ProtectedStudent extends ProtectedPerson {
    private String department;

    ProtectedStudent(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format(
                "My name is %s, I'm %d years old. I'm in %s.",
                name, age, department);
    }
}