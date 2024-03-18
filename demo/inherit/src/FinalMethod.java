public class FinalMethod {
    public static void main(String[] args) {
        ChildClass c = new ChildClass(12);
        c.show();
    }
}

class SuperClass {
    int value;
    final void show() {
        System.out.println(value);
    }
}

class ChildClass extends SuperClass {
    ChildClass(int i) {
        value = i;
    }
    // void show() { }
}
