public class MultiInstance {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        Cylinder c2 = new Cylinder();
        c1.radius = 2.8;
        c2.radius = 3.4;
        c1.height = 3;
        c2.height = 4;
    
        printCylinder(c1);
        printCylinder(c2);
    }

    static void printCylinder(Cylinder cylinder) {
        System.out.println("Radius: " + cylinder.radius);
        System.out.println("Height: " + cylinder.height);
        System.out.println("Area: " + cylinder.area());
        System.out.println("Volume: " + cylinder.volume());
    }
}
