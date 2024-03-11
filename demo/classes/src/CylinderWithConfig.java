public class CylinderWithConfig {
    double radius;
    double height;
    
    public CylinderWithConfig setRadius(double radius) {
        this.radius = radius;
        return this;
    }

    public CylinderWithConfig setHeight(double height) {
        this.height = height;
        return this;
    }

    public void config(double radius, double height) {
        setRadius(radius).setHeight(height);
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double volume() {
        return area() * height;
    }

    public static void main(String[] args) {
        CylinderWithConfig cylinder = new CylinderWithConfig();
        cylinder.config(2.8, 5);

        System.out.println(cylinder.area());
        System.out.println(cylinder.volume());
    }
}
