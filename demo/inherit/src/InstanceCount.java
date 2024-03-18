public class InstanceCount {
    public static void main(String[] args) {
        Person[] persons = new Person[10];
        for (int i = 0; i < 10; i++) {
            if (Math.random() < 0.5) {
                persons[i] = new Student("Bob", 21, "CS");
            } else {
                persons[i] = new Teacher("Eric", 33, "Java");
            }
        }

        int studentNum = 0;
        int teacherNum = 0;
        for (Person p : persons) {
            if (p instanceof Student) {
                studentNum++;
                System.out.println("Student class: " + p.getClass());
                System.out.println("Student super class: " + p.getClass().getSuperclass());
            } else {
                teacherNum++;
                System.out.println("Teacher class: " + p.getClass());
                System.out.println("Teacher super class: " + p.getClass().getSuperclass());
            }
        }

        System.out.println(String.format(
            "There are %d student and %d teachers", studentNum, teacherNum));
    }
}

class Teacher extends Person {
    String subject;
    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
}
