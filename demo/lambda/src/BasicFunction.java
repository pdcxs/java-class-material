public class BasicFunction {
    public static void main(String[] args) {
        Function f = (new Function() {
            @Override
            public double apply(int n) {
                return 2 * n;
            }
        });

        System.out.println(f.apply(12));
    }
}

interface Function {
    double apply(int n);
}
