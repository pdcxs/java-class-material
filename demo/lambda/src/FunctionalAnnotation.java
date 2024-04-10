public class FunctionalAnnotation {
    public static void main(String[] args) {
        FunctionInterface f = i -> i * 2;
        System.out.println(f.apply(3));
    }
}

@FunctionalInterface
interface FunctionInterface {
    double apply(int n);
}