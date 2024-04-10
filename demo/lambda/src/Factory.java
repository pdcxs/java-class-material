public class Factory {
    public static void main(String[] args) {
        Create c = Student::new;
        System.out.println(c.create("Eric", 12));
        System.out.println(c.create("Bob", 30));
    }
}

interface Create {
    Student create(String name, int age);
}

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }
}