import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;

@Retention(value = RetentionPolicy.RUNTIME)
@interface Author {
    String getName();
    int getAge() default 0;
}

class Person {
    @Author(getName = "Eric")
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print(String prof, int score) {
        System.out.println("Profession: " + prof + ", Score: " + score);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

@SuppressWarnings("all")
@Author(getAge = 15, getName = "Bob")
public class ReflectAndAnnotation {
    public static void main(String[] args) {
        Class<Person> person = Person.class;

        try {
            Constructor<Person> con = person.getConstructor(String.class, int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
