public class DefaultAndStatic {
    public static void main(String[] args) {
        Cylinder c = new NormalCylinder(10, 10);
        Cylinder.show(c);
        // c.show(c);
    }
}

interface Cylinder {
    public double volume();
    public default double area(double r) {
        return Math.PI * r * r;
    }
    static void show(Cylinder c) {
        System.out.println("Volume: " + c.volume());
    }
}

class NormalCylinder implements Cylinder {
    double height;
    double radius;
    NormalCylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    @Override
    public double volume() {
        return area(radius) * height;
    }
}