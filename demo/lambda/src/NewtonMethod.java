import java.util.function.*;
public class NewtonMethod {
    UnaryOperator<Double> f;
    UnaryOperator<Double> d;

    NewtonMethod(UnaryOperator<Double> f, UnaryOperator<Double> d) {
        this.f = f;
        this.d = d;
    }

    double solve(double guess) {
        double r = f.apply(guess);

        if (Math.abs(r) < 0.00001) {
            return guess;
        }
        return solve(guess - r / d.apply(guess));
    }

    public static void main(String[] args) {
        NewtonMethod nm = new NewtonMethod(i -> i * i - 2, i -> 2 * i);
        System.out.println(nm.solve(1));

        nm.f = i -> Math.tan(i) - 1;
        nm.d = i -> 1 / Math.cos(i) / Math.cos(i);
        System.out.println(4 * nm.solve(1));
    }
}
