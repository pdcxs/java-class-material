public class SmarterCylinder {
    double radius;
    double height;
    
    public double area() {
        return Math.PI * radius * radius;
    }

    public double volume() {
        return area() * height;
    }

    public static void main(String[] args) {
        SmarterCylinder cylinder = new SmarterCylinder();
        cylinder.radius = 2.8;
        cylinder.height = 5;
        System.out.println(cylinder.area());
        System.out.println(cylinder.volume());
    }
}
