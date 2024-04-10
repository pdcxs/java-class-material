import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

@Retention(value = RetentionPolicy.RUNTIME)
@interface Author {
    String getName();

    int getAge() default 0;
}

@Author(getName = "Eric", getAge = 20)
class Person {
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
        Class<Person> pc = Person.class;
        
        try {
            Constructor<Person> con = pc.getConstructor(String.class, int.class);
            System.out.print("构造方法名：" + con.getName());
            Class[] pt = con.getParameterTypes();
            for (int i = 0; i < pt.length; i++)
                System.out.print("，参数：" + pt[i].getName());
            System.out.println();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Annotation[] pca = pc.getAnnotations();
        System.out.println(pca.length);
        for (Annotation a : pca) {
            System.out.println(a.annotationType().getName());
        }
        for (Annotation c : Person.class.getAnnotations()) {
            System.out.println(c);
        }
        
        Author a = (Author)Person.class.getAnnotation(Author.class);
        System.out.println("getAge(): " + a.getAge());
        System.out.println("getName(): " + a.getName());

        Field[] fls = pc.getDeclaredFields();
        for (Field f : fls) {
            int mod = f.getModifiers();
            System.out.print("\n成员变量修饰符：" + Modifier.toString(mod));
            Class type = f.getType();
            System.out.print("；名称：" + f.getName());
            System.out.print("；类型：" + type.getName());
        }
        System.out.println();
        Method[] mds = pc.getMethods();
        for (Method m : mds) {
            System.out.print("方法：" + m.getName());
            System.out.println(" 参数个数：" + m.getParameterCount());
            Parameter[] pars = m.getParameters();
            int index = 1;
            for (Parameter p : pars) {
                if (p.isNamePresent()) {
                    System.out.println("----第" + (index++) + "个参数的信息----");
                    System.out.println("参数名：" + p.getName());
                    System.out.println("参数类型：" + p.getType());
                    System.out.println("泛型参数类型：" + p.getParameterizedType());
                    System.out.println("----------------------------------------");
                }
            }
        }
    }
}
