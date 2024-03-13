class Cylinder {
    private double radius;
    private double height;

    static final public double PI = 3.14159265;

    double area() {
        return PI * radius * radius;
    }

    double volume() {
        return area() * height;
    }

    void setRadius(double radius) {
        this.radius = radius;
    }

    double getRadius() {
        return radius;
    }

    void setHeight(double height) {
        this.height = height;
    }

    double getHeight() {
        return height;
    }

    public void setCylinder(double radius, double height) {
        if (radius > 0 && height > 0) {
            this.radius = radius;
            this.height = height;
        } else {
            System.err.println("Your cylinder data is illegal!");
        }
    }
}

public class CylinderApp {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        // Try:
        // cylinder.radius = 2.8;
        cylinder.setRadius(2.8);
        // Try:
        // cylinder.height = -5
        cylinder.setHeight(-5);

        printCylinder(cylinder);
    }

    public static void printCylinder(Cylinder cylinder) {
        System.out.println("Radius: " + cylinder.getRadius());
        System.out.println("Height: " + cylinder.getHeight());
        System.out.println("Area: " + cylinder.area());
        System.out.println("Volume: " + cylinder.volume());
    }
}