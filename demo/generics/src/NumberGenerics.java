public class NumberGenerics <T extends Number> {
    Number value;

    NumberGenerics(T value) {
        this.value = value;
    }

    double roundAtan() {
        return Math.atan((double)value.intValue());
    }

    public static void main(String[] args) {
        var n1 = new NumberGenerics<Double>(12.3);
        var n2 = new NumberGenerics<Integer>(12);

        System.out.println(n1.roundAtan());
        System.out.println(n2.roundAtan());
    }
}
