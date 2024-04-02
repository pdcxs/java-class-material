public class CustomException {
    public static void main(String[] args) {
        Circle cir = new Circle();
        try {
            cir.setRadius(-2);
        } catch (CircleException e) {
            System.out.println(e);
        }
        System.out.println(cir);
    }
}

class Circle {
    private double radius;
    public void setRadius(double r) throws CircleException {
        if (r < 0) {
            throw new CircleException(r);
        } else {
            radius = r;
        }
    }

    @Override
    public String toString() {
        return radius + "";
    }
}

class CircleException extends Exception {
    double radius;
    CircleException (double r) {
        radius = r;
    }

    @Override
    public String toString() {
        return "Radius: " + radius + " is not a positive number.";
    }
}