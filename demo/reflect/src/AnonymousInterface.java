public class AnonymousInterface {
    public static void main(String[] args) {
        MyType a = new MyType();

        a.out(new ShapeInterface() {
            @Override
            public void print() {
                System.out.println("Interface");
            }
        });

        a.out(new ShapeClass(0) {
            @Override
            public void print() {
                System.out.println("Abstract Class");
                System.out.println("a = " + this.a);
            }
        });
    }
}

interface ShapeInterface {
    void print();
}

abstract class ShapeClass {
    int a;
    public ShapeClass(int a) {
        this.a = a;
    }

    public abstract void print();
}

class MyType {
    public void out(ShapeInterface s) {
        s.print();
    }

    public void out(ShapeClass s) {
        s.print();
    }
}
