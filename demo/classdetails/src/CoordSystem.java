public class CoordSystem {
    private double r;
    private double theta;
    /*
     * private double x;
     * private double y;
     */

    public double getX() {
        return r * Math.cos(theta);
        // return x;
    }

    public double getY() {
        return r * Math.sin(theta);
        // return y;
    }

    public void setX(double x) {
        double y = getY();
        r = Math.sqrt(x * x + y * y);
        theta = Math.atan2(y, x);
        // this.x = x;
    }

    public void setY(double y) {
        double x = getX();
        r = Math.sqrt(x * x + y * y);
        theta = Math.atan2(y, x);
        // this.y = y;
    }

    public static void main(String[] args) {
        // Regardless of how the class is implemented internally
        // its external interface remains the same.
        CoordSystem coord = new CoordSystem();
        coord.setX(10);
        coord.setY(3);
        System.out.println(coord.getX() + ", " + coord.getY());
    }
}
