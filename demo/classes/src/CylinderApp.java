class Cylinder {
    double radius;
    double height;

    double area() {
        return Math.PI * radius * radius;
    }

    double volume() {
        return Math.PI * radius * radius * height;
    }

}

public class CylinderApp {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        cylinder.radius = 2.8;
        cylinder.height = 5;

        System.out.println("Area: " + cylinder.area());
        System.out.println("Volume: " + cylinder.volume());
    }
}