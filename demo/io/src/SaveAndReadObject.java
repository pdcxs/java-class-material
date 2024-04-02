import java.io.*;

public class SaveAndReadObject {
    Student[] stu = new Student[2];

    public static void main(String[] args) {
        SaveAndReadObject obj = new SaveAndReadObject();
        obj.saveObj();
        obj.readObj();
    }

    public void saveObj() {
        stu[0] = new Student("20220701", "Tom", 25);
        stu[1] = new Student("20220703", "Tom", 26);
        try (FileOutputStream fileO = new FileOutputStream("obj.dat");
                ObjectOutputStream output = new ObjectOutputStream(fileO);) {
            output.writeObject(stu[0]);
            output.writeObject(stu[1]);
            stu[0].age = 30;
            output.writeObject(stu[0]);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void readObj() {
        Student stud = null;
        try (FileInputStream fileI = new FileInputStream("obj.dat");
                ObjectInputStream input = new ObjectInputStream(fileI);) {
            for (int i = 0; i < 3; i++) {
                stud = (Student) input.readObject();
                System.out.print("Id: " + stud.id);
                System.out.print(", Name: " + stud.name);
                System.out.println(", Age" + stud.age);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

class Student implements Serializable {
    String name, id;
    int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}