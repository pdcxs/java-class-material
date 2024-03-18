interface Face1 {
    public default double area(int r) {
        return r * r * Math.PI;
    }

    abstract double volume(int r, double h);
}

interface Face2 {
    public default double area(int r) { // conflict default methods
        return r * r;
    }
}

public class NameConflict implements Face1, Face2 {
    public double area(int r) {
        return Face2.super.area(r); // specify which method to call
    }

    public double volume(int r, double h) {
        return area(r) * h;
    }

    public static void main(String[] args) {
        NameConflict ap = new NameConflict();
        System.out.println("Volume: " + ap.volume(1, 2.0));
    }
}
