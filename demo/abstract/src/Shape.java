abstract public class Shape {
    protected String name;

    Shape(String shapeName) {
        name = shapeName;
    }

    abstract double getArea();
    abstract double getCircumference();

    public static void main(String[] args) {
        Shape rect = new Rectangle(3, 4);
        System.out.println(rect);

        Shape circle = new Circle(3);
        System.out.println(circle);
    }

    @Override
    public String toString() {
        return String.format(
                "Shape: %s, area: %f, circumference: %f",
                name, getArea(), getCircumference());
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double r) {
        super("Circle");
        radius = r;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    double getCircumference() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    double getArea() {
        return width * height;
    }

    double getCircumference() {
        return 2 * (width + height);
    }
}