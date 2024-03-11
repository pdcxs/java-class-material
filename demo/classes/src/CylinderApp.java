class Cylinder {
    double radius;
    int height;

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

        System.out.println("Radius: " + cylinder.radius);
        System.out.println("Height: " + cylinder.height);
        System.out.println("Area: " + cylinder.area());
        System.out.println("Volume: " + cylinder.volume());
    }
}