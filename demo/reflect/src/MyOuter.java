public class MyOuter {
    private static final double PI = 3.14;
    private double r = 5;
    private double h = 10;

    static class SInner {
        static void area() {
            System.out.println("圆面积=" + PI * 2 * 2);
            // System.out.println(r);
        }

        void volume() {
            System.out.println("圆柱体体积=" + PI * 2 * 2 * 10);
            // System.out.println(r);
        }
    }

    class OInner {
        void area() {
            System.out.println("圆面积=" + PI * r * r);
        }

        static void volume() {
            // System.out.println(r);
        }
    }

    public static void main(String[] args) {
        MyOuter.SInner.area();
        MyOuter.SInner os = new MyOuter.SInner();
        os.volume();
        MyOuter mo = new MyOuter();
        MyOuter.OInner ns = mo.new OInner();
        ns.area();
        MyOuter.OInner.volume();
    }
}
