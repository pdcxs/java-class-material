public class CopyObject {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        c1.setCylinder(10, 20);
        CylinderApp.printCylinder(c1);
        System.out.println();

        Cylinder c2 = c1;
        c2.setCylinder(20, 30);
        CylinderApp.printCylinder(c2);

        System.out.println();
        CylinderApp.printCylinder(c1);
    }
}
