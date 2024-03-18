interface Person {
    static int maxAge = 120;
    public int getAge();
    public String getName();
}

class Teacher implements Person {
    int age;
    String name;

    Teacher(String name, int age) {
        this.name = name;

        if (age > Person.maxAge) {
            System.out.println("Amazing!");
        }

        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Student implements Person {
    int age;
    String name;

    Student(String name, int age) {
        this.name = name;

        if (age > Person.maxAge / 4) {
            System.out.println("Amazing!");
        }

        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }
}

public class PersonApp {
    public static void main(String[] args) {
        Person tchr = new Teacher("Eric", 130);
        System.out.println(tchr.getName());
        Person stu = new Student("Bob", 50);
        System.out.println(stu.getAge());
    }
}